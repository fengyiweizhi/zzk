package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/f05254f070944ff792c0dfefabd94fec?tpId=347&tqId=2634669&ru=/exam/company&qru=/ta/vip-algorithm/question-ranking&sourceUrl=%2Fexam%2Fcompany
 *
 *描述
 * 现在有一排nn块草地，第ii块草地上有w_iw
 * i
 * ​
 *  斤草，以及一个数字a_ia
 * i
 * ​
 *  。当牛牛在第ii块草地上时，他可以吃掉这个草地上所有的草，并且向右走到另一块草地。但是牛牛有强迫症，他向右走的距离必须是a_ia
 * i
 * ​
 *  的整数倍。例如：当牛牛在第33块草地，并且a_3 = 2a
 * 3
 * ​
 *  =2时，他下一步就只能前往第5,7,9,\dots,5,7,9,…,块草地。
 *
 * 牛牛可以从任意一块草地开始不断的吃草并移动到下一个草地，并且可以在任意一块草地结束它的吃草之旅。
 *
 * 现在请问，牛牛在一次吃草之旅中，最多可以吃掉多少斤草？
 * 输入描述：
 * 第一行一个整数n(1 \leq n \leq 10^3)n(1≤n≤10
 * 3
 *  )
 *
 * 接下来一行nn个整数表示w_i(1 \leq w_i \leq 100)w
 * i
 * ​
 *  (1≤w
 * i
 * ​
 *  ≤100)
 *
 * 最后一行nn个整数表示a_i (1 \leq a_i \leq 10)a
 * i
 * ​
 *  (1≤a
 * i
 * ​
 *  ≤10)
 * 输出描述：
 * 一个整数，表示答案。
 * 示例1
 * 输入：
 * 5
 * 3 5 20 7 5
 * 1 2 5 1 3
 * 输出：
 * 23
 * 复制
 * 说明：
 * 从第1块草地走到第3块，总草数为3+20=23
 * 示例2
 * 输入：
 * 3
 * 10 11 5
 * 2 1 1
 * 输出：
 * 16
 *
 * @author 风亦未止
 * @date 2023/4/1 16:50
 */
public class 牛牛吃草 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = scanner.nextInt();
        int[] w = new int[n];
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i ++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i ++){
            a[i] = scanner.nextInt();
        }
        //到达i 能吃到的最大值
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i ++){
            dp[i] = w[i];
            for(int j = 0; j < i ; j ++){
                if((i - j) % a[j] == 0 ){
                    dp[i] = Math.max(dp[i], w[i] + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}
