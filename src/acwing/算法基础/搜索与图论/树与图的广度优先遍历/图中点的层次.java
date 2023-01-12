package acwing.算法基础.搜索与图论.树与图的广度优先遍历;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/849/
 *
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环。
 *
 * 所有边的长度都是 1，点的编号为 1∼n。
 *
 * 请你求出 1 号点到 n 号点的最短距离，如果从 1 号点无法走到 n 号点，输出 −1。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含两个整数 a 和 b，表示存在一条从 a 走到 b 的长度为 1 的边。
 *
 * 输出格式
 * 输出一个整数，表示 1 号点到 n 号点的最短距离。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * 1 2
 * 2 3
 * 3 4
 * 1 3
 * 1 4
 * 输出样例：
 * 1
 *
 * @author 风亦未止
 * @date 2023/1/12 16:22
 */
public class 图中点的层次 {

    public static int N = 100010;
    public static int[] h = new int[N];
    public static int[] e = new int[2 * N];
    public static int[] ne = new int[2 * N];
    public static int idx = 0;

    public static int n;

    //模拟队列
    public static int[] q = new int[N];
    public static int[] d = new int[N];
    public static int hh = 0;
    public static int tt = -1;

    //存边
    public static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private static int bfs(int u) {
        //从 i 节点开始搜索
        q[++tt] = u;
        d[u] = 0;
        while(tt >= hh){
            int t = q[hh++];
            for(int i = h[t]; i != -1; i = ne[i]){
                int next = e[i];
                if(d[next]==-1){
                    q[++tt] = next;
                    d[next] = d[t] + 1;
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        Arrays.fill(h,-1);
        Arrays.fill(d,-1);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        while(m -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
        }
        System.out.println(bfs(1));
    }
}
