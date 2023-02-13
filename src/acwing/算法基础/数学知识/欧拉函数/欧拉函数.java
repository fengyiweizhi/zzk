package acwing.算法基础.数学知识.欧拉函数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/875/
 *
 * 给定 n 个正整数 ai，请你求出每个数的欧拉函数。
 *
 * 欧拉函数的定义
 * 1∼N 中与 N 互质的数的个数被称为欧拉函数，记为 ϕ(N)。
 * 若在算数基本定理中，N=pa11pa22…pamm，则：
 * ϕ(N) = N×p1−1p1×p2−1p2×…×pm−1pm
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个正整数 ai。
 *
 * 输出格式
 * 输出共 n 行，每行输出一个正整数 ai 的欧拉函数。
 *
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤2×109
 * 输入样例：
 * 3
 * 3
 * 6
 * 8
 * 输出样例：
 * 2
 * 2
 * 4
 *
 * @author 风亦未止
 * @date 2023/2/12 13:39
 */
public class 欧拉函数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int m = scanner.nextInt();
            int res = m;
            for(int i = 2 ; i <= m / i ; i++){
                if(m % i == 0){
                    res = res / i * (i - 1);
                    while(m % i == 0){
                        m /= i;
                    }
                }
            }
            if(m > 1){
                res = res / m * (m - 1);
            }
            System.out.println(res);
        }
    }
}
