package acwing.算法基础.数学知识.博弈论;

import java.util.Scanner;

/**
 *
 * https://www.acwing.com/problem/content/893/
 *
 *
 *给定 n 堆石子，两位玩家轮流操作，每次操作可以从任意一堆石子中拿走任意数量的石子（可以拿完，但不能不拿），最后无法进行操作的人视为失败。
 *
 * 问如果两人都采用最优策略，先手是否必胜。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个数字，其中第 i 个数字表示第 i 堆石子的数量。
 *
 * 输出格式
 * 如果先手方必胜，则输出 Yes。
 *
 * 否则，输出 No。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤每堆石子数≤109
 * 输入样例：
 * 2
 * 2 3
 * 输出样例：
 * Yes
 *
 * @author 风亦未止
 * @date 2023/2/16 16:18
 */
public class Nim游戏 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int res = 0;
        for(int num : a){
            res ^= num;
        }
        System.out.println(res == 0 ? "No" : "Yes");
    }
}
