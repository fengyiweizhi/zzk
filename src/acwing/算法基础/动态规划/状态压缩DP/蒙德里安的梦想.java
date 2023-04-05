package acwing.算法基础.动态规划.状态压缩DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/293/
 *求把 N×M 的棋盘分割成若干个 1×2 的长方形，有多少种方案。
 *
 * 例如当 N=2，M=4 时，共有 5 种方案。当 N=2，M=3 时，共有 3 种方案。
 *
 * 如下图所示：
 *
 *
 *
 * 输入格式
 * 输入包含多组测试用例。
 *
 * 每组测试用例占一行，包含两个整数 N 和 M。
 *
 * 当输入用例 N=0，M=0 时，表示输入终止，且该用例无需处理。
 *
 * 输出格式
 * 每个测试用例输出一个结果，每个结果占一行。
 *
 * 数据范围
 * 1≤N,M≤11
 * 输入样例：
 * 1 2
 * 1 3
 * 1 4
 * 2 2
 * 2 3
 * 2 4
 * 2 11
 * 4 11
 * 0 0
 * 输出样例：
 * 1
 * 0
 * 1
 * 2
 * 3
 * 5
 * 144
 * 51205
 *
 * @author 风亦未止
 * @date 2023/4/5 13:32
 */
public class 蒙德里安的梦想 {
    final  static int N = 12, M = 1 << N;
    /**
     *  表示 前i - 1已经摆好了， 伸到i 列成为状态 j 的方案 ， j可以表示如 ： 0010, i列的第三行伸出来了。
     *     先放横着的，再放竖着的。-- 其实就是求, 横着摆的方案的数量。
     */
    private static  long[][] f = new long[N][M];
    /**
     * 所有的合法状态
     */
    private static List<List<Integer>> state = new ArrayList<>(M);
    /**
     * 当前列是否能用1 * 2的小方格填满
     */
    private static boolean[] std = new boolean[M];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if(n == 0 && m ==0)break;
            //先预处理std数组，判断一个二进制表示的状态（如1001）里中所有连续的0是不是有偶数个, (所有的状态是 2的n次方 ， 1 << n, 每个二进制表示的状态有n位);
            //枚举所有的状态， 0  ~ 2的n次方 ， 预存在std；
            for(int i = 0 ; i < 1 << n; i ++ ){
                // 0 的个数
                int cnt = 0;
                boolean verify = true;
                for(int j = 0; j < n; j ++){
                     if((i >> j & 1) != 0){
                         if((cnt & 1) != 0){
                             verify = false;
                         }
                     }else {
                         cnt ++;
                     }
                }
                //判断最后一段0
                if((cnt & 1) != 0){
                    verify = false;
                }
                std[i] = verify;
            }

            //枚举: 找出所有的合法状态
            for(int i  = 0;  i < 1 << n; i ++){
                //清空上一把的合法状态
                if(i < state.size()){
                    state.get(i).clear();
                }else {
                    state.add(new ArrayList<>());
                }
                //暴力枚举所有的方案
                for(int j = 0; j < 1 << n; j++){
                     // 不能在用一行同时放 , 且所有的连续空为偶数
                    if((i & j) == 0 && std[ i | j]){
                        state.get(i).add(j);
                    }
                }
            }

            //上面都是对于状态的处理。
            //开始做dp
            for(int i = 0; i < f.length; i++){
                Arrays.fill(f[i], 0);
            }
            f[0][0] = 1;
            //开始枚举每一列
            for(int i = 1 ; i <= m; i ++){
                //枚举所有的状态
                for(int j = 0; j < 1 << n; j ++){
                    //枚举所有的合法状态
                    for(int  k : state.get(j)){
                        f[i][j] += f[i - 1][k];
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
