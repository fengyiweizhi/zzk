package com.zzk.demo;

import java.util.Scanner;

/**
 * 计算应缴金额
 * @author 风亦未止
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的账户积分");
        int integral=scanner.nextInt();
        System.out.println("请输入您的购物金额");
        int money=scanner.nextInt();
        if (integral<=2000){
            System.out.println("您的应缴金额为："+money*0.9);
        }else if(integral>2000&&integral<=4000){
            System.out.println("您的应缴金额为："+money*0.8);

        }else if(integral>4000&&integral<=8000){
            System.out.println("您的应缴金额为："+money*0.75);

        }else if (integral>8000){
            System.out.println("您的应缴金额为："+money*0.7);

        }
    }
}
