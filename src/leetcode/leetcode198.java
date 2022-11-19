package leetcode;

import java.util.Arrays;

/**
 * @author 风亦未止
 * @date 2022/2/9 22:02
 */
public class leetcode198 {
    public static void main(String[] args) {
        int rob = rob(new int[]{7, 2, 3, 4, 5});
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
