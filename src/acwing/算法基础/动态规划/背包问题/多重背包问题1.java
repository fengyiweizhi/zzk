package acwing.算法基础.动态规划.背包问题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4/
 *
 *
 *
 *
 * 有 N 种物品和一个容量是 V 的背包。
 *
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤100
 * 0<vi,wi,si≤100
 * 输入样例
 * 4 5
 * 1 2 3
 * 2 4 1
 * 3 4 3
 * 4 5 2
 * 输出样例：
 * 10
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/20 2:15
 */
public class 多重背包问题1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] n = new int[N + 1];
        for(int i = 1; i <= N ; i++){
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            n[i] = scanner.nextInt();
        }
        //前i件物品最大不超过j容量的最大价值
        int[][] dp = new int[N + 1][V + 1];
        for(int i = 1; i <= N; i++){
            int vi = v[i];
            int wi = w[i];
            int ni = n[i];
            for(int k = 0 ; k <= ni && k * vi <= V; k++){
                for(int j = k * vi; j <= V; j++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * vi] + k * wi);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
