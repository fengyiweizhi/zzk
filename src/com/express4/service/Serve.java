package com.express4.service;

import java.io.IOException;
/**
 * 服务端
 * @author 风亦未止
 */
public class Serve {
    public static void main(String[] args) throws IOException {
       ServeDao serveDao = new ServeDao();
       //启动服务端
       serveDao.start();
    }
}
