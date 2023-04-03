package acwing.算法基础.动态规划.计数类DP;

import java.util.Scanner;

/**
 * 一个正整数 n 可以表示成若干个正整数之和，形如：n=n1+n2+…+nk，其中 n1≥n2≥…≥nk,k≥1。
 *
 * 我们将这样的一种表示称为正整数 n 的一种划分。
 *
 * 现在给定一个正整数 n，请你求出 n 共有多少种不同的划分方法。
 *
 * 输入格式
 * 共一行，包含一个整数 n。
 *
 * 输出格式
 * 共一行，包含一个整数，表示总划分数量。
 *
 * 由于答案可能很大，输出结果请对 109+7 取模。
 *
 * 数据范围
 * 1≤n≤1000
 * 输入样例:
 * 5
 * 输出样例：
 * 7
 *
 * 入：10
 *
 * 出 ：42
 *
 * @author 风亦未止
 * @date 2023/4/1 21:03
 */
public class 整数划分 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        // 可以看做完全背包 ： 有 重量为 1， 2， ..... n 的物品
//        // 选择 前 i 个物品的总重量恰好为 j 的方案数量
//
//        //对于第i个物品，选择了x 个 i , 重量为j的方案为 ： f[i][j] = f[i - 1][j]  + f[i - 1][j - i] + f[i - 1][j - 2i] + .... + f[i][j - x * i] ; x * i < j
//
//        // 注： "选择 前 i 个物品 ，重量恰好为 j ，其中选择了2 个 i" 的方案 等价于 "选择了前 i - 1个物品，重量恰好为j - 2 * i" 的方案数
//        int[][] f = new int[n + 1][n + 1];
//        //一个都不选也是一种
//        f[0][0] = 1;
//        for(int i = 1; i <= n; i ++){
//            for(int j = 0; j <= n ;j ++){
//                for(int k = 0; k * i <= j ; k ++){
//                    f[i][j] += f[i - 1][j - k * i];
//                    f[i][j] %= (int) (1e9 + 7);
//                }
//            }
//        }
//        System.out.println(f[n][n]);
//    }

//    //优化背包问题
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] f = new int[n + 1];
//        // f[i][j] = f[i - 1][j]  + f[i - 1][j - i] + f[i - 1][j - 2i] + .... + f[i][j - x * i] ; x * i < j
//        // f[i][j - i] =            f[i - 1][j - i]  + f[i - 1][j - 2i] + f[i - 1][j - 3i] + .... + f[i][j - x * i] ; x * i < j
//        //得： f[i][j] = f[i - 1][j] + f[i][j - i];   ->   f[j] = f[j] + f[j - i]
//        f[0] = 1;
//        for(int i = 1; i <= n ; i ++){
//            for(int j = i; j <= n ; j ++){
//                f[j] = (f[j] + f[j - i] ) % (int)(1e9 + 7);
//            }
//        }
//        System.out.println(f[n]);
//    }



    //计数dp
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //集合划分 ： 所有总和是i ， 并且恰好表示成j个数的和的方案 ， 属性：数量
        //状态计算 ： f[i][j]  : 1 . 最小值是1 的方案数 f[i - 1][j - 1] ,  2.最小值大于1 的 f[i - j][j] ---- 每个数严格大于1 ，所以每一个减去一个1 ， 总的减去了 j
        // f[i][j] = f[i - 1][j - 1] + f[i - j][j];
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = 1;
        for(int i = 1; i <= n ; i++)f[i][0] = 0;
        for(int i = 1; i <= n ; i++)f[0][i] = 0;
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= i ; j++ ){
                f[i][j] = (f[i - 1][j - 1] + f[i - j][j])  % (int)(1e9 + 7) ;
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            res += f[n][i] ;
        }
        System.out.println(res);
    }
}
