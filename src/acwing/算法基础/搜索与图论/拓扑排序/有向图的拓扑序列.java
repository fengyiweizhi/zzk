package acwing.算法基础.搜索与图论.拓扑排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/850/
 *
 *给定一个 n 个点 m 条边的有向图，点的编号是 1 到 n，图中可能存在重边和自环。
 *
 * 请输出任意一个该有向图的拓扑序列，如果拓扑序列不存在，则输出 −1。
 *
 * 若一个由图中所有点构成的序列 A 满足：对于图中的每条边 (x,y)，x 在 A 中都出现在 y 之前，则称 A 是该图的一个拓扑序列。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含两个整数 x 和 y，表示存在一条从点 x 到点 y 的有向边 (x,y)。
 *
 * 输出格式
 * 共一行，如果存在拓扑序列，则输出任意一个合法的拓扑序列即可。
 *
 * 否则输出 −1。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 3 3
 * 1 2
 * 2 3
 * 1 3
 * 输出样例：
 * 1 2 3
 *
 *
 * @author 风亦未止
 * @date 2023/1/12 17:53
 */
public class 有向图的拓扑序列 {

    private static int N = 100010;
    private static int[] h = new int[N];
    private static int[] e = new int[2*N];
    private static int[] ne = new int[2*N];
    private static int idx = 0;
    private static int n ;

    //模拟队列
    private static int[] q = new int[N];
    private static int hh = 0;
    private static int tt = -1;

    //节点的入度数目
    private static int[] com = new int[N];

    //存边
    private static void add(int a , int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean topSort(){
        //找出出度为0 的节点
        for(int i = 1; i <= n ; i++){
            if(com[i] == 0){
                q[++tt] = i;
            }
        }
        while(tt >= hh){
            int t = q[hh++];
            for(int i = h[t]; i != -1; i = ne[i]){
                int node = e[i];
                com[node]--;
                if(com[node] == 0){
                    q[++tt] = node;
                }
            }
        }
        return tt == n - 1;
    }


    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        while(m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a, b);
            com[b]++;
        }
        if(topSort()){
            for(int i = 0; i < n; i++){
                System.out.print(q[i]+" ");
            }
        }else{
            System.out.println("-1");
        }
    }

}
