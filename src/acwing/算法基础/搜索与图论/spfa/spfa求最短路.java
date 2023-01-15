package acwing.算法基础.搜索与图论.spfa;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/853/
 *
 *给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 *
 * 请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 impossible。
 *
 * 数据保证不存在负权回路。
 *
 * 输入格式
 * 第一行包含整数 n 和 m。
 *
 * 接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 *
 * 输出格式
 * 输出一个整数，表示 1 号点到 n 号点的最短距离。
 *
 * 如果路径不存在，则输出 impossible。
 *
 * 数据范围
 * 1≤n,m≤105,
 * 图中涉及边长绝对值均不超过 10000。
 *
 * 输入样例：
 * 3 3
 * 1 2 5
 * 2 3 -3
 * 1 3 4
 * 输出样例：
 * 2
 * @author 风亦未止
 * @date 2023/1/15 17:49
 */
public class spfa求最短路 {

    private static int N = 150010;
    //邻接表存储
    private static int[] h = new int[N];
    private static int[] e = new int[2*N];
    private static int[] ne = new int[2*N];
    //该点的距离
    private static int[] w = new int[2*N];
    private static int idx = 0;

    private static int n ;

    //距离
    private static int[] dist = new int[N];
    //该点是否确定了最短距离的
    private static boolean[] st = new boolean[N];

    private static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int  spfa(){
        //优先队列 - 什么队列都行
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dist[1] = 0;
        queue.add(1);
        st[1] = true;
        while (!queue.isEmpty()){
            int t = queue.poll();
            //出队了就不记录了
            st[t] = false;
            for(int j = h[t]; j != -1; j = ne[j]){
                int nex = e[j];
                //用 t 点更新下一个点
                if ( dist[nex] > dist[t] + w[j]) {
                    dist[nex] =  dist[t] + w[j];
                    if(!st[nex]){
                        queue.add(nex);
                        st[nex] = true;
                    }
                }
            }
        }
        return dist[n] == N*N ? -10086 : dist[n];
    }


    private static void init(){
        Arrays.fill(h,-1);
        Arrays.fill(dist,N*N);
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        while(m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a, b, c);
        }
        int spfa = spfa();
        if(spfa == -10086){
            System.out.println("impossible");
        }else {
            System.out.println(spfa);
        }

    }
}
