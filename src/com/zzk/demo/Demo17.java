package com.zzk.demo;

/**
 * 排序后查找
 * @author 风亦未止
 */
public class Demo17 {
    public static void main(String[] args) {
        int[] nums={1,3,9,5,6,7,15,4,8};
        int temp;
        int front=0;
        int end=nums.length-1;
        int mid=(front+end)/2;
        int target=6;
        //下标数组
        int[] flag={0,1,2,3,4,5,6,7,8};
        int temp2;
        for (int a=1;a<nums.length-1;a++){
            for (int b=0;b<=nums.length-1-a;b++){
                if (nums[b]>nums[b+1]){
                    temp=nums[b];
                    nums[b]=nums[b+1];
                    nums[b+1]=temp;

                    temp2=flag[b];
                    flag[b]=flag[b+1];
                    flag[b+1]=temp2;
                }
            }
        }
        System.out.println("排序后：");
        for (int c=0;c<nums.length;c++){
            System.out.print(nums[c]+"\t");
        }

        while (true){
            if (target>nums[mid]){
                front=mid+1;
                mid=(front+end)/2;
            }
            else if (target<nums[mid]){
                end=mid-1;
                mid=(front+end)/2;
            }
            if (end<front){
                System.out.println("不存在");
                break;
            }
            if (target==nums[mid]){
                System.out.println("查找的数字在"+mid+"位置");
                break;
            }
        }
        System.out.println("排序后的下标为：");
        for (int c=0;c<flag.length;c++){
            System.out.print(flag[c]+"\t");
        }
    }
}
