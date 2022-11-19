package com.zzk.demo;

/**
 * @author 风亦未止
 */
public class Demo7 {
    public static void main(String[] args) {
        image1();
        image2();
        image3();

    }
    //图形一
    public static void image1(){
        for (int a=1;a<=5;a++){
            for (int b=1;b<=a;b++){
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
    //图形二
    public static void image2(){
        for(int a=5;a>=1;a--){
            for (int b=1;b<=a;b++){
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }
    //图形三
    public static void image3(){
        int d=1;
        for(int a=5;a>=1;a--){
            for (int b=1;b<=a;b++){
                System.out.print(" ");
            }
            for (int c=1;c<=d;c++){
                System.out.print("*");
            }
            d=d+2;
            //换行
            System.out.println();
        }
    }
}
