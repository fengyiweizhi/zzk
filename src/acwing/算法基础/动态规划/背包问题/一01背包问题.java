package acwing.算法基础.动态规划.背包问题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2/
 *
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 * 输出样例：
 * 8
 *
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/17 16:15
 */
public class 一01背包问题 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int v = scanner.nextInt();
//        int[][] dp = new int[n + 1][v + 1];
//        int[][] b = new int[n + 1][2];
//        for(int i = 1; i <= n ; i++ ){
//            int vv = scanner.nextInt();
//            int w = scanner.nextInt();
//            b[i] = new int[]{vv , w};
//        }
//
//        for(int i = 1; i <= n; i++){
//            int[] bb = b[i];
//            for(int j = 1 ; j <= v ;j ++){
//                if(j >= bb[0]){
//                    dp[i][j] =  Math.max(dp[i - 1][j] ,dp[i - 1][j - bb[0]] + bb[1] );
//                }else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        System.out.println(dp[n][v]);
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] dp = new int[v + 1];
        int[][] b = new int[n + 1][2];
        for(int i = 1; i <= n ; i++ ){
            int vv = scanner.nextInt();
            int w = scanner.nextInt();
            b[i] = new int[]{vv , w};
        }
        for(int i = 1; i <= n; i++){
            int[] bb = b[i];
            for(int j = v ; j >= bb[0] ;j --){
                dp[j] =  Math.max(dp[j] ,dp[j - bb[0]] + bb[1] );
            }
        }
        System.out.println(dp[v]);
    }
}
