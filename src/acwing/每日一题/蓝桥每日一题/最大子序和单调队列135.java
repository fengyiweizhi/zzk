package acwing.每日一题.蓝桥每日一题;

import java.util.Scanner;

/**
 *  https://www.acwing.com/problem/content/137/
 *
 *
 *输入一个长度为 n 的整数序列，从中找出一段长度不超过 m 的连续子序列，使得子序列中所有数的和最大。
 *
 * 注意： 子序列的长度至少是 1。
 *
 * 输入格式
 * 第一行输入两个整数 n,m。
 *
 * 第二行输入 n 个数，代表长度为 n 的整数序列。
 *
 * 同一行数之间用空格隔开。
 *
 * 输出格式
 * 输出一个整数，代表该序列的最大子序和。
 *
 * 数据范围
 * 1≤n,m≤300000
 * 输入样例：
 * 6 4
 * 1 -3 5 1 -2 3
 * 输出样例：
 * 7
 *
 * @author 风亦未止
 * @date 2023/2/27 22:10
 */
public class 最大子序和单调队列135 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] q = new int[ 2 * n];
        int hh = 0, tt = -1;
        int[] pre = new int[n + 1];
        for(int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long res = Integer.MIN_VALUE;
        // pre[i] - pre[i - k]
        for(int i = 1; i <= n ; i ++){
            if(hh <= tt && i - q[hh] > m){
                hh ++;
            }
            res = Math.max(res, pre[q[hh]] - pre[i]);
            while( hh <= tt && pre[q[tt]] >= pre[i]) {
                tt--;
            }
            q[++tt] = i;
        }
        System.out.println(res);
    }
}


