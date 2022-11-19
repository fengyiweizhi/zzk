package leetcode;

/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 风亦未止
 * @date 2022/10/28 12:45
 */
public class 子数组的最小值之和907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
    }

    public static int sumSubarrayMins(int[] nums) {
        int length = nums.length;
        long res = 0;
        long mod = 1000000007;
        for (int i = 0; i < length; i++) {
            int l = i - 1;
            while (l >= 0 && nums[i] < nums[l]) l--;
            int r = i + 1;
            while (r < length && nums[i] < nums[r]) r++;
            res += (long)(i-l)*(r-i)*nums[i];
            res %= mod;
        }
        return (int) res;
    }
}
