package acwing.算法基础.数据结构.单调队列;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 给定一个大小为 n≤106 的数组。
 * <p>
 * 有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。
 * <p>
 * 你只能在窗口中看到 k 个数字。
 * <p>
 * 每次滑动窗口向右移动一个位置。
 * <p>
 * 以下是一个例子：
 * <p>
 * 该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3。
 * <p>
 * 窗口位置	        最小值 	最大值
 * <p>
 * [1  3 -1] -3 5 3 6 7	 -1	     3
 * 1  [3 -1 -3] 5 3 6 7	 -3	     3
 * 1  3 [-1 -3 5] 3 6 7	 -3	     5
 * 1  3 -1 [-3 5 3] 6 7	 -3	     5
 * 1  3 -1 -3 [5 3 6] 7	  3	     6
 * 1  3 -1 -3 5 [3 6 7]	  3	     7
 * <p>
 * 你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 * <p>
 * 输入格式
 * 输入包含两行。
 * <p>
 * 第一行包含两个整数 n 和 k，分别代表数组长度和滑动窗口的长度。
 * <p>
 * 第二行有 n 个整数，代表数组的具体数值。
 * <p>
 * 同行数据之间用空格隔开。
 * <p>
 * 输出格式
 * 输出包含两个。
 * <p>
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 * <p>
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 * <p>
 * 输入样例：
 * 8 3
 * 1 3 -1 -3 5 3 6 7
 * 输出样例：
 * -1 -3 -3 -3 3 3
 * 3 3 5 5 6 7
 *
 * @author 风亦未止
 * @date 2022/12/5 22:28
 */
public class 滑动窗口 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[1000010];
        //队列
        int[] queue = new int[1000010];
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        //输出最小值
        for (int i = 0; i < n; i++) {
            //不在窗口内部，就删掉队头
            if (hh <= tt && i - queue[hh] + 1 > m) {
                hh++;
            }
            //对头保留最小值
            //当前的元素小于队尾元素，删掉队尾元素
            while (hh <= tt && nums[queue[tt]] >= nums[i]) {
                tt--;
            }
            queue[++tt] = i;
            if (i + 1 >= m) {
                bw.write(nums[queue[hh]] + " ");
            }
        }
        bw.write("\n");
        //初始化
        hh = 0;
        tt = -1;
        //输出最大值
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - queue[hh] + 1 > m) {
                hh++;
            }
            //对头保留最大值
            //如果当前的数值大于队尾的值，删除
            while (hh <= tt && nums[i] >= nums[queue[tt]]) {
                tt--;
            }
            queue[++tt] = i;
            if (i + 1 >= m) {
                bw.write(nums[queue[hh]] + " ");
            }
        }
        bw.close();
    }
}
