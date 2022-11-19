package com.zzk.demo;

/**
 * 移动零
 * @author 风亦未止
 */
public class Demo18 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        for (int a=1;a<nums.length-1;a++){
            for (int b=0;b<nums.length-a;b++){
                if (nums[b]==0){
                    nums[b]=nums[b+1];
                    nums[b+1]=0;
                }
            }
        }
        System.out.println("排序后");
        for (int c=0;c<=nums.length-1;c++){
            System.out.print(nums[c]+" ");
        }
    }
}
