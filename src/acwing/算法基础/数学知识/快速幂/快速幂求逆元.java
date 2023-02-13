package acwing.算法基础.数学知识.快速幂;

import java.util.Scanner;

/**
 *
 * https://www.acwing.com/problem/content/878/
 *
 * 给定 n 组 ai,pi，其中 pi 是质数，求 ai 模 pi 的乘法逆元，若逆元不存在则输出 impossible。
 *
 * 注意：请返回在 0∼p−1 之间的逆元。
 *
 * 乘法逆元的定义
 * 若整数 b，m 互质，并且对于任意的整数 a，如果满足 b|a，则存在一个整数 x，使得 a/b≡a×x(modm)，则称 x 为 b 的模 m 乘法逆元，记为 b−1(modm)。
 * b 存在乘法逆元的充要条件是 b 与模数 m 互质。当模数 m 为质数时，bm−2 即为 b 的乘法逆元。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个数组 ai,pi，数据保证 pi 是质数。
 *
 * 输出格式
 * 输出共 n 行，每组数据输出一个结果，每个结果占一行。
 *
 * 若 ai 模 pi 的乘法逆元存在，则输出一个整数，表示逆元，否则输出 impossible。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ai,pi≤2∗109
 * 输入样例：
 * 3
 * 4 3
 * 8 5
 * 6 3
 * 输出样例：
 * 1
 * 2
 * impossible
 *
 * @author 风亦未止
 * @date 2023/2/13 2:07
 */
public class 快速幂求逆元 {
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
            int p = scanner.nextInt();
            long l = q_mi(a, p - 2, p);
            if(a % p != 0){
                System.out.println(l);
            }else {
                System.out.println("impossible");
            }

        }
    }
}
