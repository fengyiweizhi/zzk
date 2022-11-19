package com.zzk.Demo6;

/**
 * Lambda表达式
 * 函数式编程思想
 *  而面向对象：创建对象调用方法解决问题
 *
 * @author 风亦未止
 */
public class Demo9 {
    public static void main(String[] args) {
        print(new MyMath() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        },100,200);

        //使用Lambda表达式
        //只保留接口参数和抽象方法体，并用->隔开
        print((int a,int b) -> {
            return a+b;
        },200,200);
    }
    public static void print(MyMath myMath,int a ,int b){
        int num=myMath.sum(a,b);
        System.out.println(num);

    }
        interface MyMath{
        int sum(int a,int b);
    }
}
