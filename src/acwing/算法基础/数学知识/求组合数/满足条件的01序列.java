package acwing.算法基础.数学知识.求组合数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/891/
 *
 *给定 n 个 0 和 n 个 1，它们将按照某种顺序排成长度为 2n 的序列，求它们能排列成的所有序列中，能够满足任意前缀序列中 0 的个数都不少于 1 的个数的序列有多少个。
 *
 * 输出的答案对 109+7 取模。
 *
 * 输入格式
 * 共一行，包含整数 n。
 *
 * 输出格式
 * 共一行，包含一个整数，表示答案。
 *
 * 数据范围
 * 1≤n≤105
 * 输入样例：
 * 3
 * 输出样例：
 * 5
 *
 * @author 风亦未止
 * @date 2023/2/16 2:39
 */
public class 满足条件的01序列 {
    public static void main(String[] args) {
        //卡特兰数 C2n n / (n + 1)
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 2 * n, b = n;
        long res = 1;
        int mod = 1000000007;
        for(int i = a; i > a - b ; i --){
            res = res * i % mod;
        }
        for(int i = 1; i <= b; i ++){
            res = res * qmi( i , mod - 2, mod) % mod;
        }
        res = res * qmi(n + 1, mod - 2 ,mod) % mod;
        System.out.println(res);
    }

    private static long qmi(long a , long k , long p){
        long res = 1;
        while(k > 0){
            if((k & 1) == 1){
                res = res * a % p;
            }
            a = a * a % p;

            k >>= 1;
        }
        return res;
    }
}
