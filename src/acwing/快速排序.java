package acwing;

import java.util.Scanner;

/**
 *
 * @author 风亦未止
 * @date 2022/8/21 16:14
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4};

        quckSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void quckSort(int[] num, int l, int r) {
        if (l >= r) return;
        int left = l , right = r;
        int p = num[l]; //里面是啥都可以
        while (left < right) {
            while(num[left]<p){
                left++;
            }
            while(num[right]>p){
                right--;
            }
            if (left < right) {
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
            }
        }
        quckSort(num, l, right);
        quckSort(num, right + 1, r);
    }

}
