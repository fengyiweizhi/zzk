package leetcode;

import java.util.Arrays;

/**
 * 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 *
 * 返回 nums 中 所有 子数组范围的 和 。
 *
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 * @author 风亦未止
 * @date 2022/3/4 9:58
 */
public class leetcode2104 {
    public static void main(String[] args) {
        long l = subArrayRanges(new int[]{1, 2, 3});
        System.out.println(l);
    }


    public static long subArrayRanges(int[] nums) {
        long result=0;

        for (int i=0;i<nums.length;i++){
            int min=nums[i];
            int max=nums[i];
          for (int j=i;j<nums.length;j++){
              //找出子数组最小和最大值
            min=Math.min(min,nums[j]);
            max=Math.max(max,nums[j]);
            result+=max-min;
          }
        }
        return result;
    }
//    public static long subArrayRanges(int[] nums) {
//        long result=0;
//        for (int i=0;i<nums.length;i++){
//            for (int j=i;j<nums.length;j++){
//                int[] childNums=new int[j-i+1];
//                for (int k=0,l=i;k<childNums.length;k++,l++){
//                    childNums[k]=nums[l];
//                }
//                result+=getResult(childNums);
//            }
//        }
//        return result;
//    }

    //获取子数组的最大差值
//    public static long getResult(int[] nums){
//        if (nums.length==1) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        return nums[nums.length-1]-nums[0];
//    }
}
