package com.zzk.Demo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全
 * @author 风亦未止
 */
public class Demo2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread window1 = new Thread(myThread2, "窗口1");
        Thread window2 = new Thread(myThread2, "窗口2");
        Thread window3 = new Thread(myThread2, "窗口3");
        window1.start();
        window2.start();
        window3.start();
    }
}
class MyThread2 implements Runnable{
    private int num=10;
    //显式锁 true:为公平锁 false：为不公平锁
    Lock lock=new ReentrantLock(true);
    @Override
    public void run() {
      while (true){
          lock.lock();//锁
          if(num>0){
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              num--;
              System.out.println(Thread.currentThread().getName()+"出票成功！余票为："+num);
          }else {
              return;
          }
          lock.unlock();//解锁
       }
    }
}
