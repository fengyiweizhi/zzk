package acwing.算法基础.搜索与图论.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/851/
 *
 *给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为正值。
 *
 * 请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。
 *
 * 输入格式
 * 第一行包含整数 n 和 m。
 *
 * 接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 *
 * 输出格式
 * 输出一个整数，表示 1 号点到 n 号点的最短距离。
 *
 * 如果路径不存在，则输出 −1。
 *
 * 数据范围
 * 1≤n≤500,
 * 1≤m≤105,
 * 图中涉及边长均不超过10000。
 *
 * 输入样例：
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 *
 *
 * 迪杰斯特拉
 *
 * @author 风亦未止
 * @date 2023/1/12 22:21
 */
public class Dijkstra求最短路I {
    private static int N = 510;
    //存边
    private static int[][] g = new int[N][N];
    //存原点到达该点的最短距离
    private static int[] dist = new int[N];

    //该点已经算好了最短距离的
    private static boolean[] st = new boolean[N];

    private static int n;

    private static int dijkstra() {
        dist[1] = 0;
        for(int i = 0 ; i < n; i++){
            int t = -1;
            //找最小边的点
            for(int j = 1; j <= n ; j++){
                //找没有确定最短路的点 , 1 到 t不是最短的
                if(!st[j] && (t == -1 || dist[t] > dist[j]) ){
                    t = j;
                }
            }
            if(t == n) break;
            st[t] = true;

            //用 t 更新其他点的距离, (t 到其他点)
            for(int j = 1; j <= n; j++ ){
                dist[j] = Math.min(dist[j], g[t][j] + dist[t]);
            }
        }
        return dist[n] == 10000 ? -1 : dist[n];
    }
    public static void main(String[] args) {
        for(int[] gg : g){
            Arrays.fill(gg, 10000);
        }
        Arrays.fill(dist, 10000);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        while(m -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            //只存最小的边
            g[a][b] = Math.min(g[a][b], c);
        }
        System.out.println(dijkstra());
    }


}
