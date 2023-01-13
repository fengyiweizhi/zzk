package acwing.算法基础.搜索与图论.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/852/
 *
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为非负值。
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
 * 1≤n,m≤1.5×105,
 * 图中涉及边长均不小于 0，且不超过 10000。
 * 数据保证：如果最短路存在，则最短路的长度不超过 109。
 *
 * 输入样例：
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 *
 * @author 风亦未止
 * @date 2023/1/12 22:21
 */
public class Dijkstra求最短路II {

    private static int N = 150010;
    //邻接表存储
    private static int[] h = new int[N];
    private static int[] e = new int[2*N];
    private static int[] ne = new int[2*N];
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

    private static int  dijkstra(){
        //优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {return a[1] - b[1];});
        dist[1] = 0;
        queue.add(new int[]{1,dist[1]});

        //出队，每次出来都是最小值
        while (!queue.isEmpty()){
            int[] t = queue.poll();
            if(st[t[0]]){
                continue;
            }
            st[t[0]] = true;
            for(int j = h[t[0]]; j != -1; j = ne[j]){
                int nex = e[j];
                if ( dist[nex] > t[1] + w[j]) {
                    dist[nex] =   t[1] + w[j];
                    queue.add(new int[]{nex,dist[nex]});
                }
            }
        }
        return dist[n] == N*N ? -1 : dist[n];
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
        System.out.println(dijkstra());
    }
}
