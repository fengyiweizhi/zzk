package com.test2;

import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;

/**
 * 高并发测试
 * @author 风亦未止
 */
public class highConcurrencyTest {
        public static void main(String[] args) {
            int count=1000;
            final CountDownLatch cdl=new CountDownLatch(count);
            for (int i = 0; i < count; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        cdl.countDown();

                        try {
                            cdl.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }

                        try {
                            connect();

                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }

                }).start();

            }

        }

        public static void connect() throws Exception {
            final String urlStr="http://47.112.234.120/";

            URL url=new URL(urlStr);

            URLConnection urlConnection = url.openConnection();

            urlConnection.setDoInput(true);

            urlConnection.setDoOutput(true);

            urlConnection.connect();

            System.out.println(urlConnection.getInputStream());

        }

}
