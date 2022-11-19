package com.zzk.demo;

import java.util.Scanner;

/**
 * 查找某个数
 * @author 风亦未止
 */
public class Demo14 {
    public static void main(String[] args) {
        int[] nums= new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int a=0;a<nums.length;a++){
            System.out.println("请输入第"+(a+1)+"个数");
            nums[a]=scanner.nextInt();
        }
        System.out.println("请输入一个需要查找的数字");
        int num=scanner.nextInt();
        int s=0;
        int e=nums.length-1;
        int mid=(s+e)/2;
        while (true){
            if (num<nums[mid]){
                e=mid-1;
            }
            else if (num>nums[mid]){
                s=mid+1;
            }
             mid=(s+e)/2;
            if (num==nums[mid]){
                System.out.println("已查找到该数字，下标为"+mid);
                break;
            }
            else if (s>e){
                System.out.println("需要查找的数组不存在");
                break;
            }
        }

    }
}
