package acwing.算法基础.数学知识.扩展欧几里得算法;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/879/
 *
 * 给定 n 对正整数 ai,bi，对于每对数，求出一组 xi,yi，使其满足 ai×xi+bi×yi=gcd(ai,bi)。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含两个整数 ai,bi。
 *
 * 输出格式
 * 输出共 n 行，对于每组 ai,bi，求出一组满足条件的 xi,yi，每组结果占一行。
 *
 * 本题答案不唯一，输出任意满足条件的 xi,yi 均可。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ai,bi≤2×109
 * 输入样例：
 * 2
 * 4 6
 * 8 18
 * 输出样例：
 * -1 1
 * -2 1
 * @author 风亦未止
 * @date 2023/2/13 2:43
 */
public class 扩展欧几里得算法 {

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
            int[] res = new int[2];
            exgcd(a, b, res);
            System.out.println( res[0] + " " + res[1]);
        }
    }
}
