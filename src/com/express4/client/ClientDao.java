package com.express4.client;

import com.express4.bean.Express;
import com.express4.bean.Interactive;
import com.express4.view.View;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 风亦未止
 */
public class ClientDao {
    private  InputStream inputStream;
    private  OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private  ObjectOutputStream objectOutputStream;
    private  HashMap<Integer,Express> expressMap;
    //客户端启动
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("客户端成功启动！");
        View view = new View();
        view.welcome();
            out:
            while (true) {
                int select = view.menu();
                //管理员
                if (select == 1) {
                    in1:
                    while (true) {
                        int select2 = view.adminMenu();
                        if (select2 == 1) {
                            Socket socket = openSocket();
                            outputStream = socket.getOutputStream();
                            //录入快递
                            Express express=view.add();
                            int code=randomCode();
                            express.setCode(code);
                            //发送请求
                            setAdd(express,outputStream);
                            //查询返回结果
                            inputStream=socket.getInputStream();
                            Express result=getResult(inputStream);
                            if (result==null){
                                view.isAdd(true);
                            }else {
                                view.isAdd(false);
                            }
                        } else if (select2 == 2) {
                            Socket socket = openSocket();
                            outputStream = socket.getOutputStream();
                            //删除快递
                            String num=view.findByNums();
                            Express express = new Express();
                            express.setNum(num);
                            setDelete(express,outputStream);
                            //获取结果
                            inputStream = socket.getInputStream();
                            Express result=getResult(inputStream);
                            if (result==null){
                                view.isDelete(false);
                                continue;
                            }
                            view.printlnExpress(result);
                            view.isDelete(true);

                        } else if (select2 == 3) {
                            Socket socket = openSocket();
                            outputStream = socket.getOutputStream();
                            //修改快递
                            String num=view.findByNums();
                            Express express=new Express();
                            express.setNum(num);
                            //发送更改请求
                            setUpdate(express,outputStream);
                            //获取请求的结果
                            inputStream = socket.getInputStream();
                            Express getExpress=getResult(this.inputStream);
                            if (getExpress==null){
                                view.isUpdate(false);
                                continue;
                            }
                            view.printlnExpress(getExpress);
                            Express newExpress = view.upData(getExpress);
                            //快递存在则发送已更新的快递
                            setUpdate(newExpress,outputStream);
                            view.isUpdate(true);

                        } else if (select2 == 4) {
                            Socket socket = openSocket();
                            outputStream = socket.getOutputStream();
                            //查看所有快递
                            //发送请求
                            setShow(outputStream);
                            //获取结果（所有快递）
                            InputStream inputStream = socket.getInputStream();
                            expressMap= getAll(inputStream);
                            view.printAll(expressMap);

                        } else if (select2 == 5) {
                            continue out;
                        }
                    }
                    //用户
                } else if (select == 2) {
                    in2:
                    while (true) {
                        int select3 = view.userMenu();
                        if (select3 == 1) {
                            Socket socket = openSocket();
                            outputStream = socket.getOutputStream();
                            //取快递
                            int byCode = view.findByCode();
                            Express express = new Express();
                            express.setCode(byCode);
                            //发送请求
                            getExpress(express,outputStream);
                            //获取结果
                            inputStream=socket.getInputStream();
                            Express getExpress=getResult(inputStream);
                            String num = null;
                            try {
                                num = getExpress.getNum();
                            } catch (Exception e) {
                                view.isSuccess(false);
                                continue;
                            }
                            view.printlnExpress(getExpress);
                            view.isSuccess(true);
                        } else if (select3 == 2) {
                            continue out;
                        }
                    }
                } else if (select == 3) {
                    break;
                }
            }
    }

    //请求增加快递
    public void setAdd(Express express,OutputStream outputStream) throws IOException {
        //新建快递
        Interactive setAdd = new Interactive("setAdd",express);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(setAdd);
    }

    //请求删除快递
    public void setDelete(Express express,OutputStream outputStream) throws IOException {
        Interactive setDelete = new Interactive("setDelete",express);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(setDelete);
    }

    //请求更改快递
    public void setUpdate(Express express,OutputStream outputStream) throws IOException {
        Interactive setUpdate = new Interactive("setUpdate",express);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(setUpdate);
    }

    //请求查看所有
    public void setShow(OutputStream outputStream) throws IOException {
        Interactive setShow = new Interactive("setShow");
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(setShow);
    }
    //请求取快递
    public void getExpress(Express express,OutputStream outputStream) throws IOException {
        Interactive interactive = new Interactive("getExpress", express);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(interactive);
    }
    //建立新的连接
    public Socket openSocket() throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        return socket;
    }

    //随机取件码
    public int randomCode() {
        int r = new Random().nextInt(900000) + 100000;
        return r;
    }
    //反序列化请求获取结果
    public Express getResult( InputStream inputStream ) throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(inputStream);
        Interactive interactive = (Interactive) objectInputStream.readObject();
        Express express = interactive.getExpress();
        return express;
    }
    //反序列化获取所有快递
    public HashMap<Integer,Express> getAll(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Interactive interactive = (Interactive) objectInputStream.readObject();
        HashMap<Integer, Express> list = interactive.getList();
        return list;
    }
    //关闭所有流
    public void closeAll() throws IOException {
        if (inputStream!=null){
            inputStream.close();
        }
        if (outputStream!=null){
            outputStream.close();
        }
        if (objectInputStream!=null){
            objectInputStream.close();
        }
        if (objectOutputStream!=null){
            objectOutputStream.close();
        }
    }
}
