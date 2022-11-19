package com.express4.client;

import java.io.IOException;

/**
 * 客户端
 * @author 风亦未止
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientDao clientDao = new ClientDao();
        //启动客户端
        clientDao.start();
    }
}
