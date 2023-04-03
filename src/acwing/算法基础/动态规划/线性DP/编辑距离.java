package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 *
 * https://www.acwing.com/problem/content/901/
 *
 * 给定 n 个长度不超过 10 的字符串以及 m 次询问，每次询问给出一个字符串和一个操作次数上限。
 *
 * 对于每次询问，请你求出给定的 n 个字符串中有多少个字符串可以在上限操作次数内经过操作变成询问给出的字符串。
 *
 * 每个对字符串进行的单个字符的插入、删除或替换算作一次操作。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 n 行，每行包含一个字符串，表示给定的字符串。
 *
 * 再接下来 m 行，每行包含一个字符串和一个整数，表示一次询问。
 *
 * 字符串中只包含小写字母，且长度均不超过 10。
 *
 * 输出格式
 * 输出共 m 行，每行输出一个整数作为结果，表示一次询问中满足条件的字符串个数。
 *
 * 数据范围
 * 1≤n,m≤1000,
 *
 * 输入样例：
 * 3 2
 * abc
 * acd
 * bcd
 * ab 1
 * acbd 2
 * 输出样例：
 * 1
 * 3
 *
 * @author 风亦未止
 * @date 2023/4/1 16:44
 */
public class 编辑距离 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] strings = new String[n];
        for(int i = 0 ; i < n ; i++){
            strings[i] = scanner.next();
        }
        int[] res = new int[m];
        for (int i = 0; i < m ; i++){
            String str = scanner.next();
            int t = scanner.nextInt();
            int len = str.length();
            char[] c1 = new char[len + 1];
            for(int j = 1; j <= len; j ++) c1[j] = str.charAt(j - 1);
            int cnt = 0;
            for(String ss : strings){
                int slen = ss.length();
                char[] c2 = new char[slen + 1];
                int[][] dp = new int[len + 1][slen + 1];
                for(int j = 1 ; j <= slen; j ++) c2[j] = ss.charAt(j - 1);
                for(int j = 0; j <= len; j ++ )dp[j][0] = j;
                for(int j = 0; j <= slen; j ++)dp[0][j] = j;
                for(int a = 1 ; a <= len; a ++){
                    for(int b = 1; b <= slen; b ++){
                        if(c1[a] == c2[b] ){
                            dp[a][b] = dp[a - 1][b - 1];
                        }else {
                            dp[a][b] = Math.min(Math.min(dp[a - 1][b], dp[a][b - 1]), dp[a - 1][b - 1]) + 1;
                        }
                    }
                }
                if(dp[len][slen] <= t){
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        for(int r : res){
            System.out.println(r);
        }
    }

}
