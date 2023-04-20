package 面试默题.排序;

import java.util.Scanner;

/**
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/15 14:03
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ; i ++){
            nums[i] = scanner.nextInt();
        }
        for(int i = n - 1; i >= 0; i --){
            for(int j = 0; j < i ; j ++ ){
                if(nums[j] > nums[j + 1]){
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        for(int num : nums){
            System.out.print(num + " ");
        }


    }
}
