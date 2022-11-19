package com.zzk.demo;

/**
 * 两个数之和
 * @author 风亦未止
 */
public class Demo16 {
    public static void main(String[] args) {
        int[] nums={10,20,23,15,25,21,12};
        int target=40;
        int temp1;
        int temp2;
        for (int a=0;a<nums.length;a++){
            temp1=nums[a];
            for (int b=0;b<nums.length;b++){
                temp2=nums[b];
                if (temp1==temp2){
                    continue;
                }
                if (target==temp1+temp2){
                    System.out.println("下标为"+a+"和"+b+"的数之和");
                }
            }
        }

    }
}
