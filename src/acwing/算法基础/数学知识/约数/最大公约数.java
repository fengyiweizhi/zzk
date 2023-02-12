package acwing.算法基础.数学知识.约数;

import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/874/
 *
 * 给定 n 对正整数 ai,bi，请你求出每对数的最大公约数。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个整数对 ai,bi。
 *
 * 输出格式
 * 输出共 n 行，每行输出一个整数对的最大公约数。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ai,bi≤2×109
 * 输入样例：
 * 2
 * 3 6
 * 4 6
 * 输出样例：
 * 3
 * 2
 * @author 风亦未止
 * @date 2023/2/11 23:42
 */
public class 最大公约数 {
    private static int fun (int x , int y){
        return y == 0 ? x : fun(y , x % y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(fun(a, b));
        }
    }

}
