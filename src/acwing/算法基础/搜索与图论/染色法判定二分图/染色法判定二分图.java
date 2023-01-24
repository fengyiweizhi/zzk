package acwing.算法基础.搜索与图论.染色法判定二分图;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 给定一个 n 个点 m 条边的无向图，图中可能存在重边和自环。
 *
 * 请你判断这个图是否是二分图。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含两个整数 u 和 v，表示点 u 和点 v 之间存在一条边。
 *
 * 输出格式
 * 如果给定图是二分图，则输出 Yes，否则输出 No。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 4
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 输出样例：
 * Yes
 *
 *
 *
 *
 * @author 风亦未止
 * @date 2023/1/20 23:21
 */
public class 染色法判定二分图 {
    final static int N = 100010;

    //邻接表
    public static int[] h = new int[N];
    public static int[] ne = new int[2 * N];
    public static int[] e = new int[2 * N];
    public static int idx = 0;

    public static int n;

    //是否被标记了
    public static int[] std = new int[N];

    public static void add(int a ,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }


    //深度优先搜索
    public static boolean dfs (int x, int flag){
        std[x] = flag;
        for(int i = h[x] ; i != -1 ; i = ne[i]){
            int ee = e[i];
            if(std[ee] == flag){
                return false;
            }else if(std[ee] == 0){
                // 1 变成 2 ， 2 变成 1
                if(! dfs(ee , 3 - flag))return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();

        while(m -- > 0){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            add(u, v);
            add(v, u);
        }
        boolean flag = true;
        //染色
        for(int i = 1 ; i <= n ; i++ ){
            if(std[i] == 0){
                if(!dfs(i, 1)){
                    flag = false;
                    break;
                }
            }
        }
        System.out.println( flag ? "Yes" : "No");
    }
}
