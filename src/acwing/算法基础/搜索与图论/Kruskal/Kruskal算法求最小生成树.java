package acwing.算法基础.搜索与图论.Kruskal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/861/
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
 * 1≤n≤105,
 * 1≤m≤2∗105,
 * 图中涉及边的边权的绝对值均不超过 1000。
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
 *
 * @author 风亦未止
 * @date 2023/1/19 18:33
 */
public class Kruskal算法求最小生成树 {
    final static int N = 200010;

    //并查集
    public static int[] p = new int[N];

    //找祖宗看是不是一个集合的
    public static int find(int x){
        if(p[x] != x ){
            p[x] = find(p[x]);
        }
        return p[x];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges= new int[m][3];
        for (int i = 0; i < m ; i++ ){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            p[u] = u;
            p[v] = v;
            edges[i] = new int[]{u , v , w};
        }
        // 按照边的大小从小到大排序
        Arrays.sort(edges,(a, b) -> {return a[2] - b[2];});
        int res = 0;
        int cnt = 0;
        //Kruskal
        for(int i = 0; i < m ; i++ ){
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];

            int j = find(u), k = find(v);
            //如果不在同集合里面，加进去
            if(j != k){
                p[j] = k;
                //边数
                cnt++;
                res += w;
            }
        }
        //边数 == 点数 - 1 说明能够生成树
        if(cnt < n - 1){
            System.out.println("impossible");
        }else{
            System.out.println(res);
        }

    }


}
