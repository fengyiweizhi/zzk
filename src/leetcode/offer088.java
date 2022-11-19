package leetcode;


import java.util.Arrays;

/**
 * 爬楼梯最低花费
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *一眼看过去典型的动态规划数组:dp[i]表示到达该阶梯所要花费的体力
* // 首先我们再来理解：动态规划：就拿第三阶级来举个例子：我们到达第三阶级有两种方法：
* // 1：从第2阶梯：跨一步：dp[3]=dp[2]+cost[2];
* // 2: 从第1阶梯：跨2步：dp[3]=dp[1]+cost[1];
* // 怎么选：当然是选花费小的：所以动态规划转移方程不就出来了吗：dp[3]=Math.min(dp[2]+cost[2],dp[1]+cost[1]);
* // 依此类推：dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
* // 这道题唯一要注意的就是：要走完最后一个阶梯才算走完
 * @author 风亦未止
 * @date 2022/2/18 16:26
 */
public class offer088 {
    public static void main(String[] args) {
        int i = minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(i);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp= new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<cost.length+1;i++){
            dp[i]=Math.min(cost[i-2]+dp[i-2],dp[i-1]+cost[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }
}
