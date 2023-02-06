package acwing.算法基础.数学知识.质数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/870/
 *
 *
 *给定一个正整数 n，请你求出 1∼n 中质数的个数。
 *
 * 输入格式
 * 共一行，包含整数 n。
 *
 * 输出格式
 * 共一行，包含一个整数，表示 1∼n 中质数的个数。
 *
 * 数据范围
 * 1≤n≤106
 * 输入样例：
 * 8
 * 输出样例：
 * 4
 *
 * @author 风亦未止
 * @date 2023/1/31 16:15
 */
public class 筛质数 {
    final static int N = 1000010;

    private static int cnt = 0;
    private static boolean[] std = new boolean[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        get_prime(n);
        System.out.println(cnt);
    }

    private static void get_prime(int n) {
        for(int i = 2; i < n ; i++){
            //如果是质数，没有被筛
            if(!std[i]){
                cnt ++;
                for(int j = i + i; j <= n ; j += i ){
                    std[j] = true;
                }
            }
        }
    }
}
