package com.zzk.demo;
import java.util.Scanner;
/**
 * @author 风亦未止
 */
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个五位数");
        int a=scanner.nextInt();
        //万
        int b=a/10000;
        //千
        int c=a/1000%10;
        //中间数字
        int mid=a/100%(b*100+c*10);
        //获取十位数
        int d=a/10%(b*1000+c*100+mid*10);
        //获取个位数
        int e=a%(b*10000+c*1000+mid*100+d*10);
        int sum=b+c+mid+d+e;
        if (b==e&&c==d){
            System.out.println("该数字是回文数");
        }else {
            System.out.println("该数字不是回文数");
        }
        System.out.println("各位数字之和为"+sum);
    }
}
