package com.zzk.demo;

import java.util.Scanner;

/**
 * 找出数组的最值
 * @author 风亦未止
 */
public class Demo15 {
    public static void main(String[] args) {
        int[] nums= new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int a=0;a<nums.length;a++){
            System.out.println("请输入第"+(a+1)+"个数");
            nums[a]=scanner.nextInt();
        }
        int num=nums[0];
        for (int b=1;b<nums.length;b++){
            num=num>nums[b]?num:nums[b];
        }
        System.out.println("最大值为"+num);
        for (int b=0;b<nums.length;b++){
            num=num<nums[b]?num:nums[b];
        }
        System.out.println("最小值为"+num);
    }
}
