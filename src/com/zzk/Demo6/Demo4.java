package com.zzk.Demo6;

/**
 * 厨师与服务员
 * @author 风亦未止
 */
public class Demo4 {
    public static void main(String[] args) {
        Food food = new Food();
        Waiter waiter = new Waiter(food);
        Cook cook = new Cook(food);
        Thread thread = new Thread(cook);
        Thread thread1 = new Thread(waiter);
        thread.start();
        thread1.start();
    }
    //厨师
   static class Cook implements Runnable{
        private Food food;
        public Cook(Food food) {
            this.food = food;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i%2==0){
                    food.setNameAndTaste("红烧牛肉","香辣味");
                }else{
                    food.setNameAndTaste("麻辣香锅","柠檬味");
                }
            }
        }
    }
    //服务员
   static class Waiter implements Runnable{
        private Food food;
        public Waiter(Food food) {
            this.food = food;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                food.get();
            }
        }
    }
   static class Food{
        private String name;
        private String taste;
        boolean flag=true;
        public synchronized void setNameAndTaste(String name, String taste){
            if (flag) {
                this.name=name;
                this.taste=taste;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("厨师做了菜：" + name + "," + taste);
                flag=false;
                this.notifyAll();//唤醒当前所有的线程
                try {
                    this.wait();//当前线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public synchronized void get(){
            if (!flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("服务员拿到了菜：" + name + "," + taste);
                flag=true;
                this.notifyAll();//唤醒当前所有的线程
                try {
                    this.wait();//当前线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}




