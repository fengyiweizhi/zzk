package acwing.算法基础.动态规划.背包问题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/9/
 *
 * 有 N 组物品和一个容量是 V 的背包。
 *
 * 每组物品有若干个，同一组内的物品最多只能选一个。
 * 每件物品的体积是 vij，价值是 wij，其中 i 是组号，j 是组内编号。
 *
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。
 *
 * 输出最大价值。
 *
 * 输入格式
 * 第一行有两个整数 N，V，用空格隔开，分别表示物品组数和背包容量。
 *
 * 接下来有 N 组数据：
 *
 * 每组数据第一行有一个整数 Si，表示第 i 个物品组的物品数量；
 * 每组数据接下来有 Si 行，每行有两个整数 vij,wij，用空格隔开，分别表示第 i 个物品组的第 j 个物品的体积和价值；
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤100
 * 0<Si≤100
 * 0<vij,wij≤100
 * 输入样例
 * 3 5
 * 2
 * 1 2
 * 2 4
 * 1
 * 3 4
 * 1
 * 4 5
 * 输出样例：
 * 8
 *
 * @author 风亦未止
 * @date 2023/2/20 16:18
 */
public class 分组背包问题 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int V = scanner.nextInt();
//        int[] s = new int[N + 1];
//        int[][] v = new int[N + 1][101];
//        int[][] w = new int[N + 1][101];
//        for(int i = 1; i <= N; i++){
//            s[i] = scanner.nextInt();
//            // 第 i 组共有 s[i] 个
//            for(int j = 1 ; j <= s[i]; j++){
//                //第 i 组的 第 j个
//                v[i][j] = scanner.nextInt();
//                w[i][j] = scanner.nextInt();
//            }
//        }
//        //前i组 选择的体积不超过 j 的 最大价值
//        int[][] dp = new int[N + 1][V + 1];
//        for(int i = 1; i <= N; i ++){
//            for(int j = 0; j <= V; j++){
//                int max = 0;
//                for(int k = 1; k <= s[i]; k ++){
//                    if(j >= v[i][k]){
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i][k]] + w[i][k]);
//                        max = Math.max(dp[i][j], max);
//                    }else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//                dp[i][j] = Math.max(dp[i][j], max);
//            }
//        }
//        System.out.println(dp[N][V]);
//    }

    //一维数组优化
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] s = new int[N + 1];
        int[][] v = new int[N + 1][101];
        int[][] w = new int[N + 1][101];
        for(int i = 1; i <= N; i++){
            s[i] = scanner.nextInt();
            // 第 i 组共有 s[i] 个
            for(int j = 1 ; j <= s[i]; j++){
                //第 i 组的 第 j个
                v[i][j] = scanner.nextInt();
                w[i][j] = scanner.nextInt();
            }
        }
        //前i组 选择的体积不超过 j 的 最大价值
        int[] dp = new int[V + 1];
        for(int i = 1; i <= N; i ++){
            for(int j = V; j >= 0; j--){
                for(int k = 1; k <= s[i]; k ++){
                    if(j >= v[i][k]){
                        dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

}
