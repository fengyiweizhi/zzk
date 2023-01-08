package acwing.算法基础.数据结构.哈希表;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/843/
 * 给定一个长度为 n 的字符串，再给定 m 个询问，每个询问包含四个整数 l1,r1,l2,r2，请你判断 [l1,r1] 和 [l2,r2] 这两个区间所包含的字符串子串是否完全相同。
 *
 * 字符串中只包含大小写英文字母和数字。
 *
 * 输入格式
 * 第一行包含整数 n 和 m，表示字符串长度和询问次数。
 *
 * 第二行包含一个长度为 n 的字符串，字符串中只包含大小写英文字母和数字。
 *
 * 接下来 m 行，每行包含四个整数 l1,r1,l2,r2，表示一次询问所涉及的两个区间。
 *
 * 注意，字符串的位置从 1 开始编号。
 *
 * 输出格式
 * 对于每个询问输出一个结果，如果两个字符串子串完全相同则输出 Yes，否则输出 No。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 8 3
 * aabbaabb
 * 1 3 5 7
 * 1 3 6 8
 * 1 2 1 2
 * 输出样例：
 * Yes
 * No
 * Yes
 *
 * 解题 ：
 * 全称字符串前缀哈希法，把字符串变成一个p进制数字（哈希值），实现不同的字符串映射到不同的数字。
 * 对形如 X1X2X3⋯Xn−1XnX1X2X3⋯Xn−1Xn 的字符串,采用字符的ascii 码乘上 P 的次方来计算哈希值。
 *
 * 映射公式 (X1×P^n−1+X2×P^n−2+⋯+Xn−1×P^1+Xn×P^0)modQ(X1×P^n−1+X2×P^n−2+⋯+Xn−1×P^1+Xn×P^0)modQ
 * 注意点：
 * 1. 任意字符不可以映射成0，否则会出现不同的字符串都映射成0的情况，比如A,AA,AAA皆为0
 * 2. 冲突问题：通过巧妙设置P (131 或 13331) , Q (2^64)(2^64)的值，一般可以理解为不产生冲突。
 *
 * 问题是比较不同区间的子串是否相同，就转化为对应的哈希值是否相同。
 * 求一个字符串的哈希值就相当于求前缀和，求一个字符串的子串哈希值就相当于求部分和。
 *
 * 前缀和公式 h[i+1]=h[i]×P+s[i]h[i+1]=h[i]×P+s[i] i∈[0,n−1]i∈[0,n−1] h为前缀和数组，s为字符串数组
 * 区间和公式 h[l,r]=h[r]−h[l−1]×Pr−l+1h[l,r]=h[r]−h[l−1]×Pr−l+1
 * 区间和公式的理解: ABCDE 与 ABC 的前三个字符值是一样，只差两位，
 * 乘上 P^2P^2 把 ABC 变为 ABC00，再用 ABCDE - ABC00 得到 DE 的哈希值。
 *
 *
 *
 * @author 风亦未止
 * @date 2023/1/7 13:37
 */
public class 字符串哈希 {
    public static int N = 100010;
    public static int P = 131;

    public static long[] h = new long[N];
    public static long[] p = new long[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        char[] ss = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            ss[i] = s.charAt(i - 1);
        }
        // 大 P 的 0 次方 等于 1
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            //大 P 的 i 次方
            p[i] = p[i - 1] * P;

            h[i] = h[i - 1] * P + ss[i];
        }
        while (m-- > 0) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            System.out.println(get(l1,r1)==get(l2,r2)?"Yes":"No");
        }
    }

    public static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
