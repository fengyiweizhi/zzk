package com.zzk.Demo6;

/**
 * 死锁
 * @author 风亦未止
 */
public class Demo3 {
    public static void main(String[] args) {
        Criminal criminal = new Criminal();
        Police police = new Police();
        Thread thread = new Thread(new MyThread3(criminal, police));
        thread.start();
        criminal.say(police);
    }

}
//线程
class MyThread3 implements Runnable{
    Criminal criminal;
    Police police;

    public MyThread3(Criminal criminal, Police police) {
        this.criminal = criminal;
        this.police = police;
    }

    @Override
    public void run() {
        police.say(criminal);
    }
}

//罪犯
class Criminal{
    public synchronized void say(Police p){
        System.out.println("罪犯：你放了我，我就放了人质");
        p.fun();
    }
    public synchronized void fun(){
        System.out.println("人质放了人，也逃走了");
    }

}
//警察
class Police{
    public synchronized void say(Criminal c){
        System.out.println("警察：你放人质，我就放了你");
        c.fun();
    }
    public synchronized void fun(){
        System.out.println("警察救了人，罪犯逃走了");
    }

}