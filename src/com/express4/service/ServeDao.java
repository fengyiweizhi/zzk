package com.express4.service;

import com.express4.bean.Express;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


/**
 * @author 风亦未止
 */
public class ServeDao {
    //快递集合
    HashMap<Integer, Express> expressMap=new HashMap<>();

    //服务器开启
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端成功启动！");
        while (true){
            //等待客户端连接
            Socket socket = serverSocket.accept();
            MyThread myThread = new MyThread(socket,expressMap);
            new Thread(myThread).start();
        }

    }

}
