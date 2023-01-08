package acwing.算法基础.搜索与图论.DFS深度优先搜索;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/845/
 *
 *
 * n−皇后问题是指将 n 个皇后放在 n×n 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。
 *
 * 1_597ec77c49-8-queens.png [https://cdn.acwing.com/media/article/image/2019/06/08/19_860e00c489-1_597ec77c49-8-queens.png]
 *
 * 现在给定整数 n，请你输出所有的满足条件的棋子摆法。
 *
 * 输入格式
 * 共一行，包含整数 n。
 *
 * 输出格式
 * 每个解决方案占 n 行，每行输出一个长度为 n 的字符串，用来表示完整的棋盘状态。
 *
 * 其中 . 表示某一个位置的方格状态为空，Q 表示某一个位置的方格上摆着皇后。
 *
 * 每个方案输出完成后，输出一个空行。
 *
 * 注意：行末不能有多余空格。
 *
 * 输出方案的顺序任意，只要不重复且没有遗漏即可。
 *
 * 数据范围
 * 1≤n≤9
 * 输入样例：
 * 4
 * 输出样例：
 * .Q..
 * ...Q
 * Q...
 * ..Q.
 *
 * ..Q.
 * Q...
 * ...Q
 * .Q..
 * @author 风亦未止
 * @date 2023/1/8 15:03
 */
public class n皇后问题 {
    public static char[][] c = new char[20][20];
    public static boolean[] col = new boolean[20];
    public static boolean[] dg = new boolean[20];
    public static boolean[] udg = new boolean[20];
    public static int n;

    //u 行
    private static void dfs(int u) {
        if(u == n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n ;j++){
                    System.out.print(String.valueOf(c[i][j]));
                }
                System.out.println();
            }
            System.out.println();
        }
        // i 列
        for(int i = 0; i < n; i++){

            // y = -x + dg  ->  dg = y + x
            // y = x + udg  -> udg = y - x  会有负数的 所以加上 n
            if(!col[i] && !dg[i + u] && ! udg[u - i + n]){
               c[u][i] = 'Q';
               dg[i + u] = true;
               udg[u - i + n] = true;
               col[i] = true;
               dfs(u+1);
               c[u][i] = '.';
               dg[i + u] = false;
               udg[u - i + n] = false;
               col[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ;j++){
                c[i][j] = '.';
            }
        }
        dfs(0);
    }

}
