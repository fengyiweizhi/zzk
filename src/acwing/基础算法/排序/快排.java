package acwing.基础算法.排序;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/9/24 18:25
 */
public class 快排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] nums=new int[i];
        for (int j=0;j<i;j++){
            nums[j]=scanner.nextInt();
        }
        quick_sort(nums,0,i-1);
        for (int num:
             nums) {
            System.out.println(num);
        }
    }

    public static void quick_sort(int[] nums,int l,int r){
        if(r<l)return;
        int left=l-1;
        int right=r+1;
        int mid=(l+r)/2;
        while (left<right){
            do{
                left++;
            }while(nums[left]<nums[mid]);
            do{
                right--;
            }while(nums[right]>nums[mid]);
            if(left<right){
                int tem=nums[left];
                nums[left]=nums[right];
                nums[right]=tem;
            }
        }
        quick_sort(nums,l,mid-1);
        quick_sort(nums,mid+1,r);
    }
}
