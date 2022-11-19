package com.zzk.Demo6;

/**
 * 线程
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread,"线程1");//设置线程名字
        thread.start();
        System.out.println(Thread.currentThread().getName()+"正在执行");//获取线程名字
        thread.interrupt();//标记线程中断
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                //当程序运行到线程中断的标记处，就会直接跳转到该处
                System.out.println("程序已关闭");
                return;//关闭此方法
            }
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }

    }
}