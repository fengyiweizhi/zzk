package acwing.算法基础.搜索与图论.Prim;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/860/
 *
 * 给定一个 n 个点 m 条边的无向图，图中可能存在重边和自环，边权可能为负数。
 *
 * 求最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
 *
 * 给定一张边带权的无向图 G=(V,E)，其中 V 表示图中点的集合，E 表示图中边的集合，n=|V|，m=|E|。
 *
 * 由 V 中的全部 n 个顶点和 E 中 n−1 条边构成的无向连通子图被称为 G 的一棵生成树，其中边的权值之和最小的生成树被称为无向图 G 的最小生成树。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含三个整数 u,v,w，表示点 u 和点 v 之间存在一条权值为 w 的边。
 *
 * 输出格式
 * 共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
 *
 * 数据范围
 * 1≤n≤500,
 * 1≤m≤105,
 * 图中涉及边的边权的绝对值均不超过 10000。
 *
 * 输入样例：
 * 4 5
 * 1 2 1
 * 1 3 2
 * 1 4 3
 * 2 3 2
 * 3 4 4
 * 输出样例：
 * 6
 *
 * @author 风亦未止
 * @date 2023/1/16 18:12
 */
public class Prim算法求最小生成树 {
    private static int N = 510;
    private static int M = 10000;
    private static int n;


    private static int[][] g;

    //确定了的
    private static boolean[] st =new boolean[N];
    //两点相连最小的边
    private static int[] dist = new int[N];

    private static int prim(){
        int res = 0;
        for(int k = 0; k < n; k++){
            int t = -1;
            //找到最小边的点
            for(int j = 1; j <= n ; j ++){
                if(!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            if(k != 0 && dist[t] == M * M){
                return -10086;
            }
            if(k != 0){
                res += dist[t];
            }
            //更新从 t -> 其他点的距离
            for(int i = 1 ; i <= n; i++){
                dist[i]  = Math.min(dist[i], g[t][i]);
            }
            st[t] = true;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        g = new int[n+1][n+1];
        //初始化
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                g[i][j] = M * M;
            }
        }
        for(int i = 1; i <= n ; i++){
            dist[i] = M * M;
        }
        while( m -- > 0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            //注意是无向图
            g[x][y] = Math.min(g[x][y], z);
            g[y][x] = Math.min(g[y][x], z);
        }
        int t = prim();
        if(t == -10086){
            System.out.println("impossible");
        }else{
            System.out.println(t);
        }

    }
}
