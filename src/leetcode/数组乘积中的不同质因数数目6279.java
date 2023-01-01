package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个正整数数组 nums ，对 nums 所有元素求积之后，找出并返回乘积中 不同质因数 的数目。
 * <p>
 * 注意：
 * <p>
 * 质数 是指大于 1 且仅能被 1 及自身整除的数字。
 * 如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,3,7,10,6]
 * 输出：4
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7 。
 * 共有 4 个不同的质因数，所以返回 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,8,16]
 * 输出：1
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 8 * 16 = 1024 = 210 。
 * 共有 1 个不同的质因数，所以返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 2 <= nums[i] <= 1000
 *
 * @author 风亦未止
 * @date 2023/1/1 12:12
 */
public class 数组乘积中的不同质因数数目6279 {


    public static int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                while (n % i == 0) {
                    set.add(i);
                    n /= i;
                }
            }
            if (n != 1) {
                set.add(n);
            }
        }
        return set.size();
    }
}
