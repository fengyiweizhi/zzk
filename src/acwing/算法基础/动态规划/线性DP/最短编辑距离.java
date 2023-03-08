package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/904/
 *给定两个字符串 A 和 B，现在要将 A 经过若干操作变为 B，可进行的操作有：
 *
 * 删除–将字符串 A 中的某个字符删除。
 * 插入–在字符串 A 的某个位置插入某个字符。
 * 替换–将字符串 A 中的某个字符替换为另一个字符。
 * 现在请你求出，将 A 变为 B 至少需要进行多少次操作。
 *
 * 输入格式
 * 第一行包含整数 n，表示字符串 A 的长度。
 *
 * 第二行包含一个长度为 n 的字符串 A。
 *
 * 第三行包含整数 m，表示字符串 B 的长度。
 *
 * 第四行包含一个长度为 m 的字符串 B。
 *
 * 字符串中均只包含大小写字母。
 *
 * 输出格式
 * 输出一个整数，表示最少操作次数。
 *
 * 数据范围
 * 1≤n,m≤1000
 * 输入样例：
 * 10
 * AGTCTGACGC
 * 11
 * AGTAAGTAGGC
 * 输出样例：
 * 4
 *
 *
 * @author 风亦未止
 * @date 2023/3/7 20:07
 */
public class 最短编辑距离 {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        int m = scanner.nextInt();
        String word1 = scanner.next();
        int n = scanner.nextInt();
        String word2 = scanner.next();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
            }
        }
        System.out.print(dp[m][n]);
    }
}
