package com.zzk.Demo6;

import java.util.concurrent.*;

/**
 * 缓存线程池（长度无限制）
 * 执行流程：
 *      1.判断线程池是否存在空闲线程
 *      2.存在则使用
 *      3.不存在，则创建线程，并放入线程池，然后使用
 * @author 风亦未止
 */
public class Demo5 {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        //向线程池中加入新的任务
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一条线程："+Thread.currentThread().getName());
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我也是一条线程："+Thread.currentThread().getName());
            }
        });
    }
}
