package acwing.算法基础.动态规划.背包问题;

import java.util.Scanner;

/**
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
 * 0<N≤1000
 * 0<V≤2000
 * 0<vi,wi,si≤2000
 * 提示：
 * 本题考查多重背包的二进制优化方法。
 *
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
 * @date 2023/2/20 15:13
 */
public class 多重背包问题2 {
    /**
     * 对多重背包问题1的优化， 二进制优化， 将s打包成 1，2,4,8，16 ...x ,能够凑出中间数，01背包问题选或者不选，即可
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[200001];
        int[] w = new int[200001];

        int idx = 1;
        for(int i = 1; i <= N ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int s = scanner.nextInt();
            int k = 1;
            while(k <= s){
                idx++;
                v[idx] = a * k;
                w[idx] = b * k;
                s -= k;
                k *= 2;
            }
            if(s > 0){
                idx ++;
                v[idx] = a * s;
                w[idx] = b * s;
            }
        }

        N = idx;
        int[] dp = new int[V+ 1];

        //01 背包
        for(int i = 1; i <= N ;i ++){
            for(int j = V ; j >= v[i]; j--){
                dp[j] = Math.max(dp[j] , dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
