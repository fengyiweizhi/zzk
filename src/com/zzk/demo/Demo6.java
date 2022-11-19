package com.zzk.demo;

import java.util.Scanner;

/**
 * 计算改年该月天数
 * @author 风亦未止
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份");
        int year=scanner.nextInt();
        System.out.println("请输入月份");
        int month=scanner.nextInt();
        //判断是不是润年
        if (year%4==0){
            switch (month){
                case 1:
                    System.out.println("该月有31天");
                    break;
                case 2:
                    System.out.println("该月有29天");
                    break;
                case 3:
                    System.out.println("该月有31天");
                    break;
                case 4:
                    System.out.println("该月有30天");
                    break;
                case 5:
                    System.out.println("该月有31天");
                    break;
                case 6:
                    System.out.println("该月有30天");
                    break;
                case 7:
                    System.out.println("该月有31天");
                    break;
                case 8:
                    System.out.println("该月有31天");
                    break;
                case 9:
                    System.out.println("该月有30天");
                    break;
                case 10:
                    System.out.println("该月有31天");
                    break;
                case 11:
                    System.out.println("该月有30天");
                    break;
                case 12:
                    System.out.println("该月有31天");
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }else {
            switch (month){
                case 1:
                    System.out.println("该月有31天");
                    break;
                case 2:
                    System.out.println("该月有28天");
                    break;
                case 3:
                    System.out.println("该月有31天");
                    break;
                case 4:
                    System.out.println("该月有30天");
                    break;
                case 5:
                    System.out.println("该月有31天");
                    break;
                case 6:
                    System.out.println("该月有30天");
                    break;
                case 7:
                    System.out.println("该月有31天");
                    break;
                case 8:
                    System.out.println("该月有31天");
                    break;
                case 9:
                    System.out.println("该月有30天");
                    break;
                case 10:
                    System.out.println("该月有31天");
                    break;
                case 11:
                    System.out.println("该月有30天");
                    break;
                case 12:
                    System.out.println("该月有31天");
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }

        }
    }
}
