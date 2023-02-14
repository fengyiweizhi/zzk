package acwing.蓝桥每日一题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3959/
 *
 * 给定一个长度为 n 的数组 a1,a2,…,an。
 *
 * 现在，要将该数组从中间截断，得到三个非空子数组。
 *
 * 要求，三个子数组内各元素之和都相等。
 *
 * 请问，共有多少种不同的截断方法？
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数 a1,a2,…,an。
 *
 * 输出格式
 * 输出一个整数，表示截断方法数量。
 *
 * 数据范围
 * 前六个测试点满足 1≤n≤10。
 * 所有测试点满足 1≤n≤105，−10000≤ai≤10000。
 *
 * 输入样例1：
 * 4
 * 1 2 3 3
 * 输出样例1：
 * 1
 * 输入样例2：
 * 5
 * 1 2 3 4 5
 * 输出样例2：
 * 0
 * 输入样例3：
 * 2
 * 0 0
 * 输出样例3：
 * 0
 * @author 风亦未止
 * @date 2023/2/14 14:49
 */
public class 截断数组前缀和3956 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        //前缀和
        int[] pre = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            pre[i] = pre[ i - 1] + nums[ i - 1];
        }
        //总和除以3不等于0的
        if(n < 3 || pre[n] % 3 != 0) {
            System.out.println(0);
            return;
        }
        long cnt = 0;
        long res = 0;
        for (int i = 2; i < n; i ++){
            if(pre[i - 1] ==  pre[n] / 3 ){
                cnt ++;
            }
            if(pre[i] == pre[n] / 3 * 2){
                res += cnt;
            }
        }
        System.out.println(res);
    }
}
