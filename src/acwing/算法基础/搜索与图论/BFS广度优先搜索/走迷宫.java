package acwing.算法基础.搜索与图论.BFS广度优先搜索;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/846/
 *
 *
 * 给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1，其中 0 表示可以走的路，1 表示不可通过的墙壁。
 *
 * 最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 *
 * 请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。
 *
 * 数据保证 (1,1) 处和 (n,m) 处的数字为 0，且一定至少存在一条通路。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 n 行，每行包含 m 个整数（0 或 1），表示完整的二维数组迷宫。
 *
 * 输出格式
 * 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 *
 * 数据范围
 * 1≤n,m≤100
 * 输入样例：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出样例：
 * 8
 * @author 风亦未止
 * @date 2023/1/9 23:17
 */
public class 走迷宫 {
    public static int[][] g = new int[110][110];
    //原点到每一个点的距离
    public static int[][] d = new int[110][110];
    public static int n;
    public static int m;

    //存分支的顶点坐标 ,模拟队列
    public static int[][] q= new int[110*110][2];
    public static int hh = 0;
    public static int tt = 0;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 0; i < n; i++){
            for(int  j = 0; j < m; j++){
                g[i][j] = scanner.nextInt();
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        for(int dd[] : d){
            Arrays.fill(dd ,-1);
        }
        q[0] = new int[]{0, 0};
        d[0][0] = 0;

        int[] dx = {0 ,1,-1, 0}, dy = {1, 0, 0, -1};

        while(hh <= tt){
            //出队
            int[] t = q[hh++];

            //遍历上下左右
            for(int i = 0; i < 4; i++){

                //走下一步的横纵坐标
                int x = t[0] + dx[i], y = t[1] + dy[i];

                if(x >=0 && x < n && y >= 0 && y < m && d[x][y] == -1 && g[x][y] == 0){
                    d[x][y] = d[t[0]][t[1]] + 1;
                    q[++tt] = new int[]{x, y};
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
