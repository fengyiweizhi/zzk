package com.zzk.demo;

/**
 * 打印99乘法表
 * @author 风亦未止
 */
public class Demo8 {
    public static void main(String[] args) {
        for(int a=1;a<=9;a++) {
            for(int b=1;b<=a;b++) {
                System.out.print(a+"*"+b+"="+a*b+"\t");
            }
            //换行
            System.out.println();
        }
    }
}
