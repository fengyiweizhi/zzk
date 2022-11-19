package com.zzk.demo;

/**
 * 打印所有三位数的水仙花数
 * @author 风亦未止
 */
public class Demo9 {
    public static void main(String[] args) {
        for (int a=100;a<=999;a++){
            //百位数
            int b=a/100;
            //十位数
            int c=(a/10)%(b*10);
            //个位数
            int e=a%(b*100+c*10);
            if (a==b*b*b+c*c*c+e*e*e){
                System.out.println(a);
            }
        }
    }
}
