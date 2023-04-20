package util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 插入排序
 *
 * @author 风亦未止
 * @date 2022/3/16 15:24
 */
public class DInsSort {
    public static void main(String[] args) {
        int[] nums = {13, 4, 9, 85, 79, 8, 5, 7};
        int[] ints = dinsSort(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] dinsSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}
