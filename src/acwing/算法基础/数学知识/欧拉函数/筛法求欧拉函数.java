package acwing.算法基础.数学知识.欧拉函数;

import java.util.Scanner;

/**
 * 给定一个正整数 n，求 1∼n 中每个数的欧拉函数之和。
 *
 * 输入格式
 * 共一行，包含一个整数 n。
 *
 * 输出格式
 * 共一行，包含一个整数，表示 1∼n 中每个数的欧拉函数之和。
 *
 * 数据范围
 * 1≤n≤106
 * 输入样例：
 * 6
 * 输出样例：
 * 12
 *
 * @author 风亦未止
 * @date 2023/2/12 15:25
 */
public class 筛法求欧拉函数 {
    final static int N = 1000010;
    private static int[] prime = new int[N];
    private static int[] phi = new int[N];
    private static int cnt = 0;
    private static boolean[] std = new boolean[N];


    private static long get_euler(int n){
        phi[1] = 1;
        for(int i = 2; i <= n; i ++){
            if(!std[i]){
                prime[cnt++] = i;
                phi[i] = i - 1;
            }
            for(int j = 0; prime[j] <= n / i ; j++){
                std[prime[j] * i ] = true;
                if( i % prime[j]  == 0){
                    phi[prime[j] * i] = prime[j] * phi[i] ;
                    break;
                }
                phi[prime[j] * i] = (prime[j] -1) * phi[i] ;
            }
        }
        long res = 0;
        for(int i = 1; i <= n; i ++){
            res += phi[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(get_euler(n));
    }
}
