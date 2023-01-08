package acwing.算法基础.搜索与图论.DFS深度优先搜索;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/844/
 *
 * 给定一个整数 n，将数字 1∼n 排成一排，将会有很多种排列方法。
 *
 * 现在，请你按照字典序将所有的排列方法输出。
 *
 * 输入格式
 * 共一行，包含一个整数 n。
 *
 * 输出格式
 * 按字典序输出所有排列方案，每个方案占一行。
 *
 * 数据范围
 * 1≤n≤7
 * 输入样例：
 * 3
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 *
 * @author 风亦未止
 * @date 2023/1/8 15:02
 */
public class 排列数字 {
    public static int n;
    public static int[] nums = new int[10];
    public static boolean[] p = new boolean[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);
    }

    private static void dfs(int i) {
        if(i == n){
            for(int j = 0 ;j < n; j++){
                System.out.print(nums[j]+" ");
            }
            System.out.println();
            return;
        }
        for(int k = 1; k <= n; k++){
            if(!p[k]){
                nums[i] = k;
                //数字 k 已使用
                p[k] = true;
                dfs(i+1);
                //回溯
                p[k] = false;
            }
        }
    }
}
