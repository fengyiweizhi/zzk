package acwing.算法基础.数学知识.扩展欧几里得算法;

import java.util.Scanner;

/**
 * 给定 n 组数据 ai,bi,mi，对于每组数求出一个 xi，使其满足 ai×xi≡bi(modmi)，如果无解则输出 impossible。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一组数据 ai,bi,mi。
 *
 * 输出格式
 * 输出共 n 行，每组数据输出一个整数表示一个满足条件的 xi，如果无解则输出 impossible。
 *
 * 每组数据结果占一行，结果可能不唯一，输出任意一个满足条件的结果均可。
 *
 * 输出答案必须在 int 范围之内。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ai,bi,mi≤2×109
 * 输入样例：
 * 2
 * 2 3 6
 * 4 3 5
 * 输出样例：
 * impossible
 * -3
 *
 * @author 风亦未止
 * @date 2023/2/13 15:24
 */
public class 线性同余方程 {
    private static int exgcd(int a , int b ,int[] res){
        if(b == 0){
            res[0] = 1;
            res[1] = 0;
            return a;
        }
        int d = exgcd(b , a % b, res);
        int tem = res[1];
        res[1] = res[0];
        res[0] = tem;
        res[1] -= a / b * res[0];
        return d;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int m = scanner.nextInt();
            int[] res = new int[2];
            int d = exgcd(a, m, res);
            if( b % d != 0){
                System.out.println("impossible");
            }else {
                //x 扩大若干倍
                System.out.println((long)res[0] * (b / d) % m);
            }
        }
    }
}
