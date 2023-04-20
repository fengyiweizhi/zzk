package 面试默题.排序;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2023/2/15 14:03
 */
public class 快速排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = scanner.nextInt();
        }
        q_sort(nums, 0 , n - 1);
        for(int i = 0; i < n ; i++){
            System.out.print(nums[i] + " ");
        }
    }

    private static void q_sort(int[] nums, int l , int r) {
        if(l >= r) return;
        int left = l - 1, right = r + 1;
        int p = nums[l];
        while(left < right){
            do {
                left ++;
            }while(nums[left] < p);
            do{
                right --;
            }while (nums[right] > p);
            if(left < right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        q_sort(nums, l, right);
        q_sort(nums, right + 1, r);
    }
}
