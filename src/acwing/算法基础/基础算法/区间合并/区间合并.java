package acwing.算法基础.基础算法.区间合并;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 * <p>
 * 注意如果在端点处相交，也算有交集。
 * <p>
 * 输出合并完成后的区间个数。
 * <p>
 * 例如：[1,3] 和 [2,6] 可以合并为一个区间 [1,6]。
 * <p>
 * 输入格式
 * 第一行包含整数 n。
 * <p>
 * 接下来 n 行，每行包含两个整数 l 和 r。
 * <p>
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * −109≤li≤ri≤109
 * 输入样例：
 * 5
 * 1 2
 * 2 4
 * 5 6
 * 7 8
 * 7 9
 * 输出样例：
 * 3
 *
 * @author 风亦未止
 * @date 2022/12/2 19:53
 */
public class 区间合并 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (a, b) -> {
            return a[0] - b[0];
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(nums[i][0] + " " + nums[i][1]);
//        }

        int ans = 1;
        int end = nums[0][1];
        for (int i = 1; i < n; i++) {
            if (end < nums[i][0]&&end<nums[i][1]) {
                ans++;
            }
            if(end<nums[i][1]){
                //更新end;
                end=nums[i][1];
            }
        }
        System.out.println(ans);
    }
}
