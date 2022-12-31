package leetcode;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * @author 风亦未止
 * @date 2022/12/8 23:26
 */
public class 绝对差不超过限制的最长连续子数组1438 {
    public static int[] maxqueue = new int[100010];
    public static int maxhh = 0;
    public static int maxtt = -1;

    public static int[] minqueue = new int[100010];
    public static int minhh = 0;
    public static int mintt = -1;

    public static int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        int max = 0;
        int left = 0;
        for (int i = 0; i < length; i++) {
            while (maxhh <= maxtt && nums[maxqueue[maxtt]] < nums[i]) {
                maxtt--;
            }
            while (minhh <= mintt && nums[minqueue[mintt]] > nums[i]) {
                mintt--;
            }
            maxqueue[++maxtt] = i;
            minqueue[++mintt] = i;
            while (maxhh <= maxtt && minhh <= mintt && nums[maxqueue[maxhh]] - nums[minqueue[minhh]] > limit) {
                if (nums[left] == nums[maxqueue[maxhh]]) {
                    maxhh++;
                }
                if (nums[left] == nums[minqueue[minhh]]) {
                    minhh++;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }
}
