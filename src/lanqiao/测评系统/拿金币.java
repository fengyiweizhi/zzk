package lanqiao.测评系统;

import java.util.Scanner;

/**
 * 问题描述
 * 　　有一个N x N的方格,每一个格子都有一些金币,只要站在格子里就能拿到里面的金币。你站在最左上角的格子里,每次可以从一个格子走到它右边或下边的格子里。请问如何走才能拿到最多的金币。
 * 输入格式
 * 　　第一行输入一个正整数n。
 * 　　以下n行描述该方格。金币数保证是不超过1000的正整数。
 * 输出格式
 * 　　最多能拿金币数量。
 * 样例输入
 * 3
 * 1 3 3
 * 2 2 2
 * 3 1 2
 * 样例输出
 * 11
 * 数据规模和约定
 * 　　n<=1000
 *
 *
 *
 * @author 风亦未止
 * @date 2023/3/30 19:41
 */
public class 拿金币 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] g = new int[n][n];
        for(int i = 0; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                g[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = g[0][0];
        for(int i = 1 ;i < n; i++){
            dp[0][i] = dp[0][i - 1] + g[0][i];
        }
        for(int i = 1 ;i < n; i++){
            dp[i][0] = dp[i - 1][0] + g[i][0];
        }
        for(int i = 1; i < n; i ++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + g[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}
