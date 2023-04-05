package acwing.算法基础.动态规划.状态压缩DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/93/
 * 给定一张 n 个点的带权无向图，点从 0∼n−1 标号，求起点 0 到终点 n−1 的最短 Hamilton 路径。
 *
 * Hamilton 路径的定义是从 0 到 n−1 不重不漏地经过每个点恰好一次。
 *
 * 输入格式
 * 第一行输入整数 n。
 *
 * 接下来 n 行每行 n 个整数，其中第 i 行第 j 个整数表示点 i 到 j 的距离（记为 a[i,j]）。
 *
 * 对于任意的 x,y,z，数据保证 a[x,x]=0，a[x,y]=a[y,x] 并且 a[x,y]+a[y,z]≥a[x,z]。
 *
 * 输出格式
 * 输出一个整数，表示最短 Hamilton 路径的长度。
 *
 * 数据范围
 * 1≤n≤20
 * 0≤a[i,j]≤107
 * 输入样例：
 * 5
 * 0 2 4 5 1
 * 2 0 6 5 3
 * 4 6 0 8 3
 * 5 5 8 0 5
 * 1 3 3 5 0
 * 输出样例：
 * 18
 *
 * @author 风亦未止
 * @date 2023/4/5 13:36
 */
public class 最短Hamilton路径 {
    final static int N = 21, M = 1 << N ;
    private static int[][] f = new int[M][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] w = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n ; j ++){
                w[i][j] = scanner.nextInt();
            }
        }
        //从 0 走到 j, 走过了所有的点是状态i的所有路径。  如 i = (010) 第一点没走 ，第二点走了，第三点没走
        //属性，最小值
        //根据倒数第二个点是几进行分类 ，0 ， 1 ，2 ， 3 ，4 ，.. .. n -1
        for(int i = 0 ; i < 1 << n ; i ++){
            Arrays.fill(f[i], (int)1e9 + 7);
        }
        f[1][0] = 0;
        //枚举所有的状态
        for(int i = 0; i < 1 << n; i ++){
           for(int j = 0 ; j < n ; j ++){
               //i 里包j的走过
               if( (i >> j & 1) != 0){
                    for(int k = 0; k < n ; k ++){
                        // 要符合 i - {j} == k 的话，i - {j} 包含k
                        if(((i - (1 << j) ) >> k  & 1) != 0){
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
               }
           }
        }
        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}
