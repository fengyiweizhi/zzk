package acwing.算法基础.搜索与图论.bellmanFord;

import java.util.Arrays;
import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/855/
 *
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 *
 * 请你求出从 1 号点到 n 号点的最多经过 k 条边的最短距离，如果无法从 1 号点走到 n 号点，输出 impossible。
 *
 * 注意：图中可能 存在负权回路 。
 *
 * 输入格式
 * 第一行包含三个整数 n,m,k。
 *
 * 接下来 m 行，每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 *
 * 点的编号为 1∼n。
 *
 * 输出格式
 * 输出一个整数，表示从 1 号点到 n 号点的最多经过 k 条边的最短距离。
 *
 * 如果不存在满足条件的路径，则输出 impossible。
 *
 * 数据范围
 * 1≤n,k≤500,
 * 1≤m≤10000,
 * 1≤x,y≤n，
 * 任意边长的绝对值不超过 10000。
 *
 * 输入样例：
 * 3 3 1
 * 1 2 1
 * 2 3 1
 * 1 3 3
 * 输出样例：
 * 3
 *
 *
 * @author 风亦未止
 * @date 2023/1/14 20:46
 */
public class 有边数限制的最短路 {
    final static int N  = 510;
    final static int M = 10010;


    //到达点的最短距离
    public static int[] dist = new int[2*M];
    //备份数组
    public static int[] backup = new int[N];

    public static int n;
    public static int m;
    public static int k;


    public static int bellmanFord( int[][] g) {
        Arrays.fill(dist, 2*M);
        dist[1] = 0;
        for(int i = 1; i <= k; i++){
            //备份，保证不会串联
            backup = Arrays.copyOf(dist, dist.length);
            //遍历边
            for(int j = 0; j < m; j ++){
                int[] w = g[j];
                int x = w[0], y = w[1], z = w[2];
                dist[y] = Math.min(dist[y], backup[x] + z);
            }
        }
        return dist[n] > 2*M / 2 ? -10086 : dist[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        // {x, y, z} 边
        int[][] g = new int[m][3];
        for(int i = 0; i < m ; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            g[i] = new int[]{x, y, z};
        }
        int t = bellmanFord(g);
        if(t == -10086){
            System.out.println("impossible");
        }else{
            System.out.println(t);
        }

    }

}
