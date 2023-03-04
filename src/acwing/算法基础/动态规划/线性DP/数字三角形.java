package acwing.算法基础.动态规划.线性DP;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/900/
 *
 *
 *
 * 给定一个如下图所示的数字三角形，从顶部出发，在每一结点可以选择移动至其左下方的结点或移动至其右下方的结点，一直走到底层，要求找出一条路径，使路径上的数字的和最大。
 *
 *         7
 *       3   8
 *     8   1   0
 *   2   7   4   4
 * 4   5   2   6   5
 * 输入格式
 * 第一行包含整数 n，表示数字三角形的层数。
 *
 * 接下来 n 行，每行包含若干整数，其中第 i 行表示数字三角形第 i 层包含的整数。
 *
 * 输出格式
 * 输出一个整数，表示最大的路径数字和。
 *
 * 数据范围
 * 1≤n≤500,
 * −10000≤三角形中的整数≤10000
 * 输入样例：
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 输出样例：
 * 30
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/20 18:13
 */
public class 数字三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j <= i; j ++){
                nums[i][j] = scanner.nextInt();
            }
        }
        for(int i = n - 2; i >= 0; i -- ){
            for(int j = i; j >= 0; j--){
                nums[i][j] = Math.max(nums[i + 1][j], nums[i + 1][j + 1] ) + nums[i][j];
            }
        }
        System.out.println(nums[0][0]);
    }
}
