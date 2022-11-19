package com.zzk.Demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**定长线程池。(长度是指定的数值)
 * 任务加入后的执行流程：
 *      1.判断线程池是否存在空闲线程
 *      2.存在则使用
 *      3.不存在空闲线程，且线程池未满的情况下，则创建线程 并放入线程池，然后使用
 *      4,。不存在空闲线程，且线程池已满的情况下，则等待线程池存在空闲线程
 * @author 风亦未止
 */
public class Demo6 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}
