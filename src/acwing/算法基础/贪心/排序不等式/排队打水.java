package acwing.算法基础.贪心.排序不等式;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  https://www.acwing.com/problem/content/description/915/
 *
 *
 *有 n 个人排队到 1 个水龙头处打水，第 i 个人装满水桶所需的时间是 ti，请问如何安排他们的打水顺序才能使所有人的等待时间之和最小？
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数，其中第 i 个整数表示第 i 个人装满水桶所花费的时间 ti。
 *
 * 输出格式
 * 输出一个整数，表示最小的等待时间之和。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ti≤104
 * 输入样例：
 * 7
 * 3 6 1 4 2 5 7
 * 输出样例：
 * 56
 *
 * @author 风亦未止
 * @date 2023/4/24 14:32
 */
public class 排队打水 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i ++){
            nums[i] = scanner.nextInt();
        }
        long res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n ; i++){
            res += (long)nums[i] * (n - 1 - i);
        }
        System.out.println(res);
    }
}
