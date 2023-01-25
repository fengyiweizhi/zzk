package acwing.算法基础.搜索与图论.匈牙利算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/863/
 *
 *
 *
 * 给定一个二分图，其中左半部包含 n1 个点（编号 1∼n1），右半部包含 n2 个点（编号 1∼n2），二分图共包含 m 条边。
 *
 * 数据保证任意一条边的两个端点都不可能在同一部分中。
 *
 * 请你求出二分图的最大匹配数。
 *
 * 二分图的匹配：给定一个二分图 G，在 G 的一个子图 M 中，M 的边集 {E} 中的任意两条边都不依附于同一个顶点，则称 M 是一个匹配。
 *
 * 二分图的最大匹配：所有匹配中包含边数最多的一组匹配被称为二分图的最大匹配，其边数即为最大匹配数。
 *
 * 输入格式
 * 第一行包含三个整数 n1、 n2 和 m。
 *
 * 接下来 m 行，每行包含两个整数 u 和 v，表示左半部点集中的点 u 和右半部点集中的点 v 之间存在一条边。
 *
 * 输出格式
 * 输出一个整数，表示二分图的最大匹配数。
 *
 * 数据范围
 * 1≤n1,n2≤500,
 * 1≤u≤n1,
 * 1≤v≤n2,
 * 1≤m≤105
 * 输入样例：
 * 2 2 4
 * 1 1
 * 1 2
 * 2 1
 * 2 2
 * 输出样例：
 * 2
 *
 * @author 风亦未止
 * @date 2023/1/20 23:26
 */
public class 二分图的最大匹配 {
    final static int N = 501;
    final static int M = 100010;
    //邻接表
    private static int[] h = new int[N];
    private static int[] e = new int[2 * M];
    private static int[] nex = new int[2 * M];
    private static int idx = 0;

    private static boolean[] std = new boolean[N];
    //match[右边] = 左边  做匹配
    private static int[] match = new int[N];


    private static void add(int u, int v) {
        e[idx] = v;
        nex[idx] = h[u];
        h[u] = idx++;
    }


    private static boolean find(int x) {
        for(int i = h[x]; i != -1; i = nex[i]){
            int ee = e[i];
            if(!std[ee]){
                std[ee] = true;
                if(match[ee] == 0 || find(match[ee])){
                    match[ee] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int m = scanner.nextInt();
        while(m -- > 0){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            add(u, v);
        }
        int res = 0;
        //开始为左边匹配
        for(int i = 1 ; i <= n1; i++){
            //初始化清空匹配
            Arrays.fill(std, false);
            if(find(i)){
                res ++;
            }
        }
        System.out.println(res);
    }

}
