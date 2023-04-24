package acwing.算法基础.贪心.区间问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/908/
 *
 *
 *
 *给定 N 个闭区间 [ai,bi]，请你将这些区间分成若干组，使得每组内部的区间两两之间（包括端点）没有交集，并使得组数尽可能小。
 *
 * 输出最小组数。
 *
 * 输入格式
 * 第一行包含整数 N，表示区间数。
 *
 * 接下来 N 行，每行包含两个整数 ai,bi，表示一个区间的两个端点。
 *
 * 输出格式
 * 输出一个整数，表示最小组数。
 *
 * 数据范围
 * 1≤N≤105,
 * −109≤ai≤bi≤109
 * 输入样例：
 * 3
 * -1 1
 * 2 4
 * 3 5
 * 输出样例：
 * 2
 *
 *
 *
 * @author 风亦未止
 * @date 2023/4/23 21:16
 */
public class 区间分组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (a , b) -> {return a[0] - b[0];});
        int res = 1;
        for(int i = 1; i < n; i++){
            if(nums[i - 1][1] < nums[i][0]){
                continue;
            }
            res ++;
        }
        System.out.println(res);
    }
}
