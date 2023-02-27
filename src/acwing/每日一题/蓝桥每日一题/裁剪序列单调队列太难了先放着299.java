package acwing.每日一题.蓝桥每日一题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/301/
 *
 *
 * 给定一个长度为 N 的序列 A，要求把该序列分成若干段，在满足“每段中所有数的和”不超过 M 的前提下，让“每段中所有数的最大值”之和最小。
 *
 * 试计算这个最小值。
 *
 * 输入格式
 * 第一行包含两个整数 N 和 M。
 *
 * 第二行包含 N 个整数，表示完整的序列 A。
 *
 * 输出格式
 * 输出一个整数，表示结果。
 *
 * 如果结果不存在，则输出 −1。
 *
 * 数据范围
 * 0≤N≤105,
 * 0≤M≤1011,
 * 序列A中的数非负，且不超过106
 * 输入样例：
 * 8 17
 * 2 2 2 8 1 8 2 1
 * 输出样例：
 * 12
 *
 *
 * @author 风亦未止
 * @date 2023/2/27 12:50
 */
public class 裁剪序列单调队列太难了先放着299 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n + 1];
        int[] w = new int[n + 1];
        for(int i = 1; i <= n ; i ++){
            nums[i] = scanner.nextInt();
            if(nums[i] > m){
                System.out.println(-1);
                return;
            }
        }
        int hh = 0, tt = -1;
        long sum = 0;
        for(int i = 1, j = 1; i <= n; i ++){
            sum += w[i];
            while (sum > m){
                sum -= w[j ++];
                if(hh < tt ){

                }
            }


        }

    }







}
