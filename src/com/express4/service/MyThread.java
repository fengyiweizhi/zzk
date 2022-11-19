package com.express4.service;

import com.express4.bean.Express;
import com.express4.bean.Interactive;

import java.io.*;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 处理信息线程类
 * @author 风亦未止
 */
public class MyThread extends Thread{
    private Socket socket;
    //服务端上快递的集合
    private HashMap<Integer, Express> expressMap;
    private  InputStream inputStream;
    private  OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private  ObjectOutputStream objectOutputStream;
    public MyThread(Socket socket, HashMap<Integer,Express> expressMap){
        this.socket = socket;
        this.expressMap = expressMap;
    }
    @Override
    public void run() {
            try {
                inputStream= socket.getInputStream();
                outputStream = socket.getOutputStream();
                //反序列化
                Interactive interactive= (Interactive) deSerialize(inputStream);
                String flag=interactive.getFlag();
                if (flag.equals("setAdd")){
                    //增加快递
                    Express express=interactive.getExpress();
                    //通过单号查找，是否存在单号相同的情况
                    String num=express.getNum();
                    Express find=findByNum(num);
                    if (find==null){
                        int code=express.getCode();
                        expressMap.put(code,express);
                        System.out.println("运单号"+express.getNum()+"的快递已添加，"+"取件码为："+express.getCode());
                        result(find,outputStream);
                    }else {
                        result(find,outputStream);
                        System.out.println("单号存在，用户添加失败");
                    }
                }else if (flag.equals("setDelete")){
                    //删除快递
                    Express express=interactive.getExpress();
                    String num=express.getNum();
                    //通过单号查找
                    Express findExpress = findByNum(num);
                    int code = 0;
                    try {
                        code = findExpress.getCode();
                    } catch (Exception e) {
                        System.out.println("用户查询的单号不存在，删除失败");
                        return;
                    }finally {
                        //返回结果
                        result(findExpress,outputStream);
                    }
                    expressMap.remove(code);
                    System.out.println("运单号"+express.getNum()+"的快递已删除");
                   // close(inputStream);
                }else if (flag.equals("setUpdate")){
                    //更改快递
                    Express express=interactive.getExpress();
                    String num = express.getNum();
                    Express findExpress=findByNum(num);
                    int code = 0;
                    try {
                        code = findExpress.getCode();
                    } catch (NullPointerException e) {
                        System.out.println("用户查询的单号不存在！更新失败");
                        return;
                    }finally {
                        //返回结果
                        result(findExpress,outputStream);
                    }
                    //得到最新的快递
                    Interactive interactive2= (Interactive) deSerialize(inputStream);
                    Express newExpress=interactive2.getExpress();
                    int newCode = newExpress.getCode();
                    //删除旧的快递
                    expressMap.remove(code);
                    //添加新的快递
                    expressMap.put(newCode,newExpress);
                    System.out.println("已更新快递信息");
                }else if(flag.equals("setShow")){
                    //查看所有
                    sandAll(outputStream);

                }else if (flag.equals("getExpress")){
                    Express express=interactive.getExpress();
                    int code = express.getCode();
                    Express byCode = findByCode(code);
                    String num = null;
                    try {
                        num = byCode.getNum();
                    } catch (Exception e) {
                        System.out.println("用户输入的取件码不存在，取件失败");
                        return;
                    } finally {
                        result(byCode,outputStream);
                    }
                    expressMap.remove(code);
                    System.out.println("用户取走了单号为"+num+"的快递");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //关闭所有流
                try {
                    closeAll();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

    }
    //反序列化操作
    public Object deSerialize(InputStream inputStream) throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(inputStream);
        Object o= objectInputStream.readObject();
        return o;
    }
    //通过单号查询
    public Express findByNum(String num){
        Express express=new Express();
        Express express1;
        express.setNum(num);
        //获取集合中的数据
        Collection<Express> value=expressMap.values();
        //迭代器
        Iterator<Express> iterator = value.iterator();
        while (iterator.hasNext()){
            express1=iterator.next();
            if (express.equals(express1)){
                return express1;
            }
        }
        return null;
    }
    //通过取件码查询
    public Express findByCode(int code){
        Express express = expressMap.get(code);
        return express;
    }
    //所有的快递
    public HashMap<Integer,Express> showAll(){
        return expressMap;
    }
    //返回查询的快递
    public void result(Express express,OutputStream outputStream) throws IOException {
        Interactive interactive = new Interactive(express);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(interactive);
    }
    //发送所有的快递
    public void sandAll(OutputStream outputStream) throws IOException {
        HashMap<Integer, Express> integerExpressHashMap = showAll();
        Interactive interactive = new Interactive(integerExpressHashMap);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(interactive);
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
        if (socket!=null){
            socket.close();
        }


   }
}
