package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/899/
 *
 *给定两个长度分别为 N 和 M 的字符串 A 和 B，求既是 A 的子序列又是 B 的子序列的字符串长度最长是多少。
 *
 * 输入格式
 * 第一行包含两个整数 N 和 M。
 *
 * 第二行包含一个长度为 N 的字符串，表示字符串 A。
 *
 * 第三行包含一个长度为 M 的字符串，表示字符串 B。
 *
 * 字符串均由小写字母构成。
 *
 * 输出格式
 * 输出一个整数，表示最大长度。
 *
 * 数据范围
 * 1≤N,M≤1000
 * 输入样例：
 * 4 5
 * acbd
 * abedc
 * 输出样例：
 * 3
 *
 *
 * @author 风亦未止
 * @date 2023/3/4 17:56
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s1= scanner.next();
        String s2 = scanner.next();
        char[] a = new char[n + 1];
        for(int i = 1; i <= n ;i++){
            a[i] = s1.charAt(i - 1);
        }
        char[] b = new char[m + 1];
        for(int i = 1; i <= m; i ++){
            b[i] = s2.charAt(i - 1);
        }
        //这个集合表示： 所有由第一个序列的前i个字母中出现且在第二个序列前j个字母中出现的子序列
        //集合划分{
        // a[i]和b[j]是否在包含在子序列当中， 四种情况 - a[i] 在，b[j] 不在。 a[i] 在 b[i] 在 ...
        // 00， 01 ，10 ，11

        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j] , f[i][j - 1]);
                if(a[i] == b[j]){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
