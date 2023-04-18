package 杂题.美团笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 *小美套娃
 *
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美最近喜欢上了玩套娃。
 *
 * 具体的，小美有 n 个套娃，第 i 个套娃的大小为 ai，内部空间为 bi(bi≤ai)。对于两个套娃x,y， x能放入y中当且仅当ax≤by ，且放入后会占据 y 大小为 ax 的内部空间，即 y 的内部空间剩下 by-ax，每个套娃只能放在另外的一个套娃内，每个套娃内部也只能放一个套娃（当然内部放的这个套娃可以内部还有套娃）。
 *
 * 显然套娃是套的越多越好，于是小美给每个套娃定义了一个价值 ci，如果套完之后套娃 i 还剩 k 的内部空间，小美需要付出ci*k  的花费，总花费为所有套娃的花费之和，现在小美想知道最小的花费为多少。
 *
 *
 *
 * 输入描述
 * 第一行一个正整数 n ，表示套娃的个数
 *
 * 接下来三行每行 n 个整数，分别为
 *
 * a1,a2,...an
 *
 * b1,b2,...bn
 *
 * c1,c2,...,cn
 *
 * 1≤n,ai,bi,ci,≤100000，bi≤ai
 *
 * 输出描述
 * 输出一个整数表示最小的花费
 *
 *
 * 样例输入
 * 3
 * 5 4 3
 * 4 2 2
 * 3 2 1
 * 样例输出
 * 6
 *
 * 提示
 * 样例解释
 *
 * 将第二个套娃放在第一个里面，第三个不动，这样第一个套娃剩 0 的空间，第二个剩 2，第三个剩 2。总花费为0*3+2*2+2*1=6 。可以证明这是花费最小的方案。
 * @author 风亦未止
 * @date 2023/4/15 10:49
 */
public class 小美玩套娃 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for(int i = 0; i < n ; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < n ; i++){
            b[i] = scanner.nextInt();
        }
        for(int i = 0; i < n ; i++){
            c[i] = scanner.nextInt();
        }

        int[][] nums = new int[n][3] ;
        for(int i = 0; i < n; i ++){
            nums[i] = new int[]{a[i],b[i],c[i]};
        }
        Arrays.sort(nums,(l,r)->{return  r[1] - l[1]; });
        int res = 0;
        for(int i = 0; i < n - 1; i ++){
            res += (nums[i][1] - nums[i + 1][0]) * nums[i][2];
        }
        System.out.println(res);
    }
}
