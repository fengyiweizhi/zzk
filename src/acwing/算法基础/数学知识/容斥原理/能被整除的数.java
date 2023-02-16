package acwing.算法基础.数学知识.容斥原理;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/892/
 *
 * 给定一个整数 n 和 m 个不同的质数 p1,p2,…,pm。
 *
 * 请你求出 1∼n 中能被 p1,p2,…,pm 中的至少一个数整除的整数有多少个。
 *
 * 输入格式
 * 第一行包含整数 n 和 m。
 *
 * 第二行包含 m 个质数。
 *
 * 输出格式
 * 输出一个整数，表示满足条件的整数的个数。
 *
 * 数据范围
 * 1≤m≤16,
 * 1≤n,pi≤109
 * 输入样例：
 * 10 2
 * 2 3
 * 输出样例：
 * 7
 *
 *
 * @author 风亦未止
 * @date 2023/2/16 14:53
 */
public class 能被整除的数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] p = new int[m];
        for(int i = 0; i < m; i++){
            p[i] = scanner.nextInt();
        }

        long res = 0;
        for(int i = 1; i < 1 << m; i++){
            int t = 1 , cnt = 0;
            for(int j = 0; j < m; j++){
                if( (i >> j & 1) == 1){
                    cnt ++;
                    if((long)t * (long)p[j] > n){
                        t = -1;
                        break;
                    }
                    t *= p[j];
                }
            }
            if(t != -1){
                if(cnt % 2 != 0){
                    res += n / t;
                }else{
                    res -= n / t;
                }
            }
        }
        System.out.println(res);
    }
}
