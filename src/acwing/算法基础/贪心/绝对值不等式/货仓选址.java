package acwing.算法基础.贪心.绝对值不等式;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/106/
 *在一条数轴上有 N 家商店，它们的坐标分别为 A1∼AN。
 *
 * 现在需要在数轴上建立一家货仓，每天清晨，从货仓到每家商店都要运送一车商品。
 *
 * 为了提高效率，求把货仓建在何处，可以使得货仓到每家商店的距离之和最小。
 *
 * 输入格式
 * 第一行输入整数 N。
 *
 * 第二行 N 个整数 A1∼AN。
 *
 * 输出格式
 * 输出一个整数，表示距离之和的最小值。
 *
 * 数据范围
 * 1≤N≤100000,
 * 0≤Ai≤40000
 * 输入样例：
 * 4
 * 6 2 9 1
 * 输出样例：
 * 12
 *
 *
 *
 * @author 风亦未止
 * @date 2023/4/24 14:37
 */
public class 货仓选址 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ; i++){
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        //证明是数组的中间值
        int res = 0;
        for(int i = 0; i  < n ; i++){
            res += Math.abs(nums[i] - nums[n / 2]);
        }
        System.out.println(res);
    }
}
