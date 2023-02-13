package acwing.算法基础.数学知识.中国剩余定理;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/206/
 *
 * 给定 2n 个整数 a1,a2,…,an 和 m1,m2,…,mn，求一个最小的非负整数 x，满足 ∀i∈[1,n],x≡mi(mod ai)。
 *
 * 输入格式
 * 第 1 行包含整数 n。
 *
 * 第 2…n+1 行：每 i+1 行包含两个整数 ai 和 mi，数之间用空格隔开。
 *
 * 输出格式
 * 输出最小非负整数 x，如果 x 不存在，则输出 −1。
 * 如果存在 x，则数据保证 x 一定在 64 位整数范围内。
 *
 * 数据范围
 * 1≤ai≤231−1,
 * 0≤mi<ai
 * 1≤n≤25
 * 输入样例：
 * 2
 * 8 7
 * 11 9
 * 输出样例：
 * 31
 *
 * @author 风亦未止
 * @date 2023/2/13 16:41
 */
public class 表达整数的奇怪方式 {
    private static long exgcd(long a , long b ,long[] res){
        if(b == 0){
            res[0] = 1;
            res[1] = 0;
            return a;
        }
        long d = exgcd(b , a % b, res);
        long tem = res[1];
        res[1] = res[0];
        res[0] = tem;
        res[1] -= a / b * res[0];
        return d;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() - 1;
        boolean have_ans = true;
        long a1 = scanner.nextInt();
        long m1 = scanner.nextInt();
        while(n -- > 0){
            int an = scanner.nextInt();
            int mn = scanner.nextInt();
            long[] k = new long[2];
            long d = exgcd(a1, an, k);
            if((mn - m1) % d != 0){
                have_ans = false;
                break;
            }
            k[0] *= (mn - m1) / d;
            long t = an / d;
            k[0] = ( k[0] % t + t) %t;

            m1  = a1 * k[0] + m1;
            a1 = Math.abs(a1 / d * an);
        }
        if(have_ans){
            System.out.println((m1 % a1 + a1) %  a1);
        }else {
            System.out.println("-1");
        }
    }
}
