package acwing.算法基础.贪心.区间问题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 给定 N 个闭区间 [ai,bi] 以及一个线段区间 [s,t]，请你选择尽量少的区间，将指定线段区间完全覆盖。
 *
 * 输出最少区间数，如果无法完全覆盖则输出 −1。
 *
 * 输入格式
 * 第一行包含两个整数 s 和 t，表示给定线段区间的两个端点。
 *
 * 第二行包含整数 N，表示给定区间数。
 *
 * 接下来 N 行，每行包含两个整数 ai,bi，表示一个区间的两个端点。
 *
 * 输出格式
 * 输出一个整数，表示所需最少区间数。
 *
 * 如果无解，则输出 −1。
 *
 * 数据范围
 * 1≤N≤105,
 * −109≤ai≤bi≤109,
 * −109≤s≤t≤109
 * 输入样例：
 * 1 5
 * 3
 * -1 3
 * 2 4
 * 3 5
 * 输出样例：
 * 2
 *
 * @author 风亦未止
 * @date 2023/4/23 22:42
 */
public class 区间覆盖 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n ; i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (a, b) -> {return a[0] - b[0];});
        int res = 0;
        for(int i = 0; i < n ; i++){
            //遍历所有在start之前的左边端点，找出最大的右端点
            int j = i , mr = Integer.MIN_VALUE;
            while(j < n && nums[j][0] <= start){
                mr = Math.max(mr, nums[j][1]);
                j ++;
            }
            if(start > mr){
                System.out.print(-1);
                return;
            }
            start = mr;
            res++;
            if(mr >= end)break;
            i = j - 1;
        }
        if(start < end){
            System.out.print(-1);
        }else{
            System.out.print(res);
        }
    }
}
