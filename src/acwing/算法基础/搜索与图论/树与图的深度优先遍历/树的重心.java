package acwing.算法基础.搜索与图论.树与图的深度优先遍历;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/848/
 *
 * 给定一颗树，树中包含 n 个结点（编号 1∼n）和 n−1 条无向边。
 *
 * 请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。
 *
 * 重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。
 *
 * 输入格式
 * 第一行包含整数 n，表示树的结点数。
 *
 * 接下来 n−1 行，每行包含两个整数 a 和 b，表示点 a 和点 b 之间存在一条边。
 *
 * 输出格式
 * 输出一个整数 m，表示将重心删除后，剩余各个连通块中点数的最大值。
 *
 * 数据范围
 * 1≤n≤105
 * 输入样例
 * 9
 * 1 2
 * 1 7
 * 1 4
 * 2 8
 * 2 5
 * 4 3
 * 3 9
 * 4 6
 * 输出样例：
 * 4
 *
 * @author 风亦未止
 * @date 2023/1/11 16:21
 */
public class 树的重心 {

    //邻接表  --  类似拉链法存储
    private static int[] hh = new int[100010];
    private static int[] ne = new int[200020];
    private static int[] e = new int[200020];
    private static int idx = 0;

    private static int ans = 100010;
    private static int n;
    //被搜过的记录
    private static boolean[] st = new boolean[100010];

    private static void add(int a, int b){
        //头插法
        e[idx] = b;
        ne[idx] = hh[a];
        hh[a] = idx++;
    }

    private static void init(){
        Arrays.fill(hh,-1);
    }

    //以u为 根 的子树中节点的数量
    private static int dfs(int u) {
        st[u] = true;

        int sum = 1, res = 0;
        for (int i = hh[u]; i != -1; i = ne[i]) {
            int nextIndex = e[i];
            //没被搜过
            if(!st[nextIndex]){
                int s = dfs(nextIndex);
                //找子节点
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(res, ans);
        return sum;
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0 ; i < n -1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans);
    }

}
