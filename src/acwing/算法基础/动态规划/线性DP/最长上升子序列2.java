package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/898/
 *
 *给定一个长度为 N 的数列，求数值严格单调递增的子序列的长度最长是多少。
 *
 * 输入格式
 * 第一行包含整数 N。
 *
 * 第二行包含 N 个整数，表示完整序列。
 *
 * 输出格式
 * 输出一个整数，表示最大长度。
 *
 * 数据范围
 * 1≤N≤100000，
 * −109≤数列中的数≤109
 * 输入样例：
 * 7
 * 3 1 2 1 8 5 6
 * 输出样例：
 * 4
 *
 * @author 风亦未止
 * @date 2023/3/1 19:26
 */
public class 最长上升子序列2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1; i <= n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] f = new int[n + 1];
        for(int i = 1; i <= n ; i++ ){
            f[i] = 1;
            for(int j = 1; j <= i - 1; j ++){
                if(nums[i] > nums [j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for(int r : f){
            res = Math.max(r , res);
        }
        System.out.println(res);
    }
}
