package acwing.算法基础.搜索与图论.spfa;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/854/
 *
 *
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 *
 * 请你判断图中是否存在负权回路。
 *
 * 输入格式
 * 第一行包含整数 n 和 m。
 *
 * 接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 *
 * 输出格式
 * 如果图中存在负权回路，则输出 Yes，否则输出 No。
 *
 * 数据范围
 * 1≤n≤2000,
 * 1≤m≤10000,
 * 图中涉及边长绝对值均不超过 10000。
 *
 * 输入样例：
 * 3 3
 * 1 2 -1
 * 2 3 4
 * 3 1 -4
 * 输出样例：
 * Yes
 * @author 风亦未止
 * @date 2023/1/15 17:50
 */
public class spfa判断负环 {

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
    //边数  如果 cnt[n] > n 存在负权边
    private static int[] cnt = new int[N];
    //该点是否确定了最短距离的
    private static boolean[] st = new boolean[N];

    private static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean  spfa(){
        //优先队列 - 什么队列都行
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //因为从某个点开始可能到达不了其他的点，就可能找不到其他点是否存在负权回路，所以需要把所有的点放入队列中
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }
        while (!queue.isEmpty()){
            int t = queue.poll();
            //出队了就不记录了
            st[t] = false;
            for(int j = h[t]; j != -1; j = ne[j]){
                int nex = e[j];
                //用 t 点更新下一个点// 初始化时dist都为0，如果存在负权回路时执行
                if(dist[nex] > dist[t] + w[j]){
                    cnt[nex] = cnt[t] + 1;
                    dist[nex] = dist[t] + w[j];
                    if(cnt[nex] >= n){
                        return true;
                    }
                    if(!st[nex]){
                        queue.add(nex);
                        st[nex] = true;
                    }
                }
            }
        }
       return false;
    }

    private static void init(){
        Arrays.fill(h,-1);
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
        if(spfa()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

}
