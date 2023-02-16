package acwing.算法基础.数学知识.博弈论;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/896/
 *
 *
 * 给定 n 堆石子，两位玩家轮流操作，每次操作可以取走其中的一堆石子，然后放入两堆规模更小的石子（新堆规模可以为 0，且两个新堆的石子总数可以大于取走的那堆石子数），最后无法进行操作的人视为失败。
 *
 * 问如果两人都采用最优策略，先手是否必胜。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数，其中第 i 个整数表示第 i 堆石子的数量 ai。
 *
 * 输出格式
 * 如果先手方必胜，则输出 Yes。
 *
 * 否则，输出 No。
 *
 * 数据范围
 * 1≤n,ai≤100
 * 输入样例：
 * 2
 * 2 3
 * 输出样例：
 * Yes
 *
 *
 * @author 风亦未止
 * @date 2023/2/16 17:47
 */
public class 拆分Nim游戏 {
    private static int N = 101;
    private static int[] f = new int[N];

    public static void main(String[] args) {
        Arrays.fill(f , -1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int res = 0;
        for(int i = 0; i < n ; i++){
            nums[i] = scanner.nextInt();
            res ^= sg(nums[i]);
        }
        System.out.println( res == 0 ? "No" : "Yes");
    }

    private static int sg(int x) {
        if(f[x] != -1){
            return f[x];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < x; i++){
            for(int j = 0; j <= i; j ++){
                set.add(sg(i) ^ sg(j));
            }
        }
        for(int i = 0; ;i ++ ){
            if(!set.contains(i)){
                f[x] = i;
                return i;
            }
        }
    }
}
