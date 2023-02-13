package acwing.算法基础.数学知识.快速幂;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/877/
 *
 * 给定 n 组 ai,bi,pi，对于每组数据，求出 abiimodpi 的值。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含三个整数 ai,bi,pi。
 *
 * 输出格式
 * 对于每组数据，输出一个结果，表示 abiimodpi 的值。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n≤100000,
 * 1≤ai,bi,pi≤2×109
 * 输入样例：
 * 2
 * 3 2 5
 * 4 3 9
 * 输出样例：
 * 4
 * 1
 *
 *
 * @author 风亦未止
 * @date 2023/2/12 16:52
 */
public class 快速幂 {

    // a的k次方模p
    public static long q_mi(int aa, int k , int p){
        long  res = 1;
        long a = aa;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(q_mi(a, k , p));
        }
    }
}
