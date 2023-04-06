package acwing.算法基础.动态规划.记忆化搜索;
import java.util.*;
/**
 * https://www.acwing.com/problem/content/903/
 *给定一个 R 行 C 列的矩阵，表示一个矩形网格滑雪场。
 *
 * 矩阵中第 i 行第 j 列的点表示滑雪场的第 i 行第 j 列区域的高度。
 *
 * 一个人从滑雪场中的某个区域内出发，每次可以向上下左右任意一个方向滑动一个单位距离。
 *
 * 当然，一个人能够滑动到某相邻区域的前提是该区域的高度低于自己目前所在区域的高度。
 *
 * 下面给出一个矩阵作为例子：
 *
 *  1  2  3  4 5
 *
 * 16 17 18 19 6
 *
 * 15 24 25 20 7
 *
 * 14 23 22 21 8
 *
 * 13 12 11 10 9
 * 在给定矩阵中，一条可行的滑行轨迹为 24−17−2−1。
 *
 * 在给定矩阵中，最长的滑行轨迹为 25−24−23−…−3−2−1，沿途共经过 25 个区域。
 *
 * 现在给定你一个二维矩阵表示滑雪场各区域的高度，请你找出在该滑雪场中能够完成的最长滑雪轨迹，并输出其长度(可经过最大区域数)。
 *
 * 输入格式
 * 第一行包含两个整数 R 和 C。
 *
 * 接下来 R 行，每行包含 C 个整数，表示完整的二维矩阵。
 *
 * 输出格式
 * 输出一个整数，表示可完成的最长滑雪长度。
 *
 * 数据范围
 * 1≤R,C≤300,
 * 0≤矩阵中整数≤10000
 * 输入样例：
 * 5 5
 * 1 2 3 4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * 输出样例：
 * 25
 *
 *
 * @author 风亦未止
 * @date 2023/4/5 13:37
 */
public class 滑雪 {
    final static int N = 301;
    private static int n , m; 
    //集合表示： 表示从i，j 点滑的下去的搜有路径的集合
    //属性：最大值 
    //状态计算： 从当前的i，j 上下左右走 ，假设网右走一个格子 f[i][j + 1]，当前的f[i][j] = f[i][j + 1] + 1 ,1为当前的格子;
    private static int[][] f = new int[N][N];
    private static int[][] h = new int[N][N];

    //上下左右走
    private static int[][] ne = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int dp(int i , int j){
        //如过算过了
        if(f[i][j] != -1)return f[i][j];
        //初始化 最小1；
        f[i][j] = 1;
        //遍历四个方向
        for(int k = 0; k < 4; k++){
            int x = ne[k][0] + i;
            int y = ne[k][1] + j;
            //在边界内
            if(x >= 1 && x <= n && y >= 1 && y <= m && h[i][j] > h[x][y]){
                f[i][j] = Math.max(f[i][j], dp(x, y) + 1);
            }
        }
        return f[i][j];
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                h[i][j] = scanner.nextInt();
            }
        }
        //初始化f为-1 ，表示都没走过
        for(int i = 1; i <= n; i++){
            Arrays.fill(f[i], -1);
        }
        int res = 0;
        //枚举每一个点找出最大的结果
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                res = Math.max(res, dp(i, j));
            }   
        }
        System.out.println(res);
    }

}
