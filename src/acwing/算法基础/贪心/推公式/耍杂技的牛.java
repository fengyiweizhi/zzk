package acwing.算法基础.贪心.推公式;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/127/
 *
 * 农民约翰的 N 头奶牛（编号为 1..N）计划逃跑并加入马戏团，为此它们决定练习表演杂技。
 *
 * 奶牛们不是非常有创意，只提出了一个杂技表演：
 *
 * 叠罗汉，表演时，奶牛们站在彼此的身上，形成一个高高的垂直堆叠。
 *
 * 奶牛们正在试图找到自己在这个堆叠中应该所处的位置顺序。
 *
 * 这 N 头奶牛中的每一头都有着自己的重量 Wi 以及自己的强壮程度 Si。
 *
 * 一头牛支撑不住的可能性取决于它头上所有牛的总重量（不包括它自己）减去它的身体强壮程度的值，现在称该数值为风险值，风险值越大，这只牛撑不住的可能性越高。
 *
 * 您的任务是确定奶牛的排序，使得所有奶牛的风险值中的最大值尽可能的小。
 *
 * 输入格式
 * 第一行输入整数 N，表示奶牛数量。
 *
 * 接下来 N 行，每行输入两个整数，表示牛的重量和强壮程度，第 i 行表示第 i 头牛的重量 Wi 以及它的强壮程度 Si。
 *
 * 输出格式
 * 输出一个整数，表示最大风险值的最小可能值。
 *
 * 数据范围
 * 1≤N≤50000,
 * 1≤Wi≤10,000,
 * 1≤Si≤1,000,000,000
 * 输入样例：
 * 3
 * 10 3
 * 2 5
 * 3 3
 * 输出样例：
 * 2
 *
 * @author 风亦未止
 * @date 2023/4/24 14:38
 */
public class 耍杂技的牛 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (a , b) -> {return  b[0] + b[1] - (a[0] + a[1]);});
        long[] w = new  long[n];
        w[0] = nums[0][0];
        for(int i = 1; i < n; i ++ ){
            w[i] = (long)w[i - 1] + nums[i][0];
        }
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            max = Math.max(max, w[n - 1] - w[i] - nums[i][1]);
        }
        System.out.println(max);
    }
}
