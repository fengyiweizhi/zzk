package acwing.算法基础.数学知识.求组合数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/889/
 *
 *
 *给定 n 组询问，每组询问给定三个整数 a,b,p，其中 p 是质数，请你输出 Cbamodp 的值。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一组 a,b,p。
 *
 * 输出格式
 * 共 n 行，每行输出一个询问的解。
 *
 * 数据范围
 * 1≤n≤20,
 * 1≤b≤a≤1018,
 * 1≤p≤105,
 *
 * 输入样例：
 * 3
 * 5 3 7
 * 3 1 5
 * 6 4 13
 * 输出样例：
 * 3
 * 3
 * 2
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/15 3:37
 */
public class 求组合数3 {
    private static int p ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0 ){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
             p = scanner.nextInt();
            System.out.println(lucas(a, b));
        }
    }

    private static long lucas(long a, long b) {
        if(a < p && b < p){
            return C(a , b);
        }
        return C(a % p, b % p) * lucas(a / p, b / p)  % p;
    }

    //求Cab
    private static long C(long a, long b) {
        long res = 1;
        for(long i = 1, j = a; i <= b; i++ , j -- ){
            res = (res * j) % p;
            res = res * qmi(i , p - 2) % p ;
        }
        return res;
    }

    private static long qmi(long a, int k) {
        long  res = 1;
        while(k > 0){
            //如果k的二进制末尾是1
            if((k & 1) == 1){
                res = (res * a) % p;
            }
            //更新a ，将这次求的模平方再模给下一次(上次模的结果的平方的模)
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }
}
