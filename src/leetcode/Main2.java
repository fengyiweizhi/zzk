package leetcode;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 输入：nums = [10,9,2,5,3,7,101,18]
 输出：4
 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @author 风亦未止
 * @date 2022/1/12 23:13
 */
public class Main2 {
    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(i);
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int maxLength=1;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
