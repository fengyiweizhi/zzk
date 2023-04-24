package acwing.算法基础.贪心.区间问题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/910/
 *
 *
 *
 * 给定 N 个闭区间 [ai,bi]，请你在数轴上选择若干区间，使得选中的区间之间互不相交（包括端点）。
 *
 * 输出可选取区间的最大数量。
 *
 * 输入格式
 * 第一行包含整数 N，表示区间数。
 *
 * 接下来 N 行，每行包含两个整数 ai,bi，表示一个区间的两个端点。
 *
 * 输出格式
 * 输出一个整数，表示可选取区间的最大数量。
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
 * @author 风亦未止
 * @date 2023/4/23 21:15
 */
public class 最大不相交区间数量 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n ; i ++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (a, b) -> {return a[0] - b[0]; });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            //每次维护所有组中最小的右端点的组。
            if(queue.isEmpty() || queue.peek()  >= nums[i][0]){
                queue.offer(nums[i][1]);
            }else {
                //取出最小的右端点的组 与当前组合并 和 为一组, 更新这组的右端点，放入堆中
                queue.poll();
                queue.offer(nums[i][1]);
            }
        }
        System.out.println(queue.size());
    }

}
