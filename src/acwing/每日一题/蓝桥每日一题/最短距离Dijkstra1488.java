package acwing.每日一题.蓝桥每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 有 N 个村庄，编号 1 到 N。
 *
 * 村庄之间有 M 条无向道路，第 i 条道路连接村庄 ai 和村庄 bi，长度是 ci。
 *
 * 所有村庄都是连通的。
 *
 * 共有 K 个村庄有商店，第 j 个有商店的村庄编号是 xj。
 *
 * 然后给出 Q 个询问，第 k 个询问给出一个村庄的编号 yk，问该村庄距离最近的商店有多远？
 *
 * 输入格式
 * 第一行包含两个整数 N,M。
 *
 * 接下来 M 行，每行包含三个整数 ai,bi,ci，表示第 i 条道路连接村庄 ai 和村庄 bi，长度是 ci。
 *
 * 再一行包含整数 K。
 *
 * 接下来 K 行，每行包含一个整数 xj，表示第 j 个有商店的村庄编号是 xj。
 *
 * 再一行包含整数 Q。
 *
 * 接下来 Q 行，每行包含一个整数 yk，表示询问编号为 yk 的村庄与其距离最近的商店之间的距离。
 *
 * 输出格式
 * 对于每个询问，输出该询问的结果。
 *
 * 数据范围
 * 2≤N≤105,
 * N−1≤M≤min(N(N−1)2,105),
 * 1≤Q≤105,
 * 1≤K≤N,
 * 1≤ci≤10000
 * 输入样例：
 * 7 7
 * 1 2 5
 * 1 4 3
 * 2 3 2
 * 2 5 1
 * 3 6 7
 * 5 6 8
 * 6 7 6
 * 3
 * 7
 * 5
 * 4
 * 7
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 输出样例：
 * 3
 * 1
 * 3
 * 0
 * 0
 * 6
 * 0
 *
 *
 * @author 风亦未止
 * @date 2023/3/20 20:25
 */
public class 最短距离Dijkstra1488 {
    final static int N = 100010;
    private static int n;
    private static int m;
    private static int q;

    private static int[] h = new int[N];
    private static int[] e = new int[3 * N];
    private static int[] ne = new int[3 * N];
    private static int[] w = new int[3 * N];

    private static int[] dist = new int[N];

    private static boolean[] shop = new boolean[N];
    private static int[] shopdist = new int[N];
    private static boolean[] std = new boolean[N];
    private static int idx = 0;

    private static void add(int a, int b , int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }


    public static void D(){
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y)->{return x[1] - y[1];});
        dist[0] = 0;
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] t = queue.poll();
            if(std[t[0]]){
                continue;
            }
            std[t[0]] = true;
            for(int i = h[t[0]]; i != -1 ; i = ne[i]){
                int ee = e[i];
                if(dist[ee] > t[1] + w[i]){
                    dist[ee] = t[1] + w[i];
                    queue.add(new int[]{ee, dist[ee]});
                }

            }
        }
    }


    public static void main(String[] args){
        Arrays.fill(h, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(std, false);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while(m -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        int shopN = scanner.nextInt();

        while(shopN -- > 0){
            int s = scanner.nextInt();
            add(0, s, 0);
        }
        D();
        q = scanner.nextInt();
        while(q --> 0){
            int a = scanner.nextInt();
            System.out.println(dist[a]);
        }

    }


}
