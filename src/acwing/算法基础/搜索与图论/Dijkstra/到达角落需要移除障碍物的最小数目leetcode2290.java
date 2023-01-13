package acwing.算法基础.搜索与图论.Dijkstra;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
 *
 * 0 表示一个 空 单元格，
 * 1 表示一个可以移除的 障碍物 。
 * 你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
 *
 * 现在你需要从左上角 (0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。
 *
 *  
 *
 * 示例 1：
 *
 * https://assets.leetcode.com/uploads/2022/04/06/example1drawio-1.png
 *
 * 输入：grid = [[0,1,1],[1,1,0],[1,1,0]]
 * 输出：2
 * 解释：可以移除位于 (0, 1) 和 (0, 2) 的障碍物来创建从 (0, 0) 到 (2, 2) 的路径。
 * 可以证明我们至少需要移除两个障碍物，所以返回 2 。
 * 注意，可能存在其他方式来移除 2 个障碍物，创建出可行的路径。
 * 示例 2：
 *
 *https://assets.leetcode.com/uploads/2022/04/06/example1drawio.png
 *
 * 输入：grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
 * 输出：0
 * 解释：不移除任何障碍物就能从 (0, 0) 到 (2, 4) ，所以返回 0 。
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * grid[i][j] 为 0 或 1
 * grid[0][0] == grid[m - 1][n - 1] == 0
 *
 * 链接：https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner
 *
 *
 * @author 风亦未止
 * @date 2023/1/13 22:53
 */
public class 到达角落需要移除障碍物的最小数目leetcode2290 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumObstacles(new int[][]{{0,1,1}, {1,1,0}, {1,1,0}});
        System.out.println(i);
    }


    static class Solution {

        public int minimumObstacles(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            //移动到该点需要 移除障碍物的数目
            int[][] d = new int[n][m];
            //是否走过了
            boolean[][] st = new boolean[n][m];

            PriorityQueue<int[]> queue =  new PriorityQueue<>((a, b) -> {return a[2] - b[2];});
            d[0][0] = 0;
            // i j d  d障碍物的数目
            queue.add(new int[]{0 ,0 ,0});

            int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1 , 0};

            while(!queue.isEmpty()){
                int[] t = queue.poll();
                int dd = t[2];
                for(int i = 0; i < 4; i++){
                    int x = t[0] + dx[i];
                    int y = t[1] + dy[i];
                    if(x  >=0 && x < n && y >=0 && y < m && !st[x][y]){
                        //是障碍物
                        if(grid[x][y] == 1){
                            d[x][y] = dd + 1;
                        }else{
                            d[x][y] = dd;
                        }
                        queue.add(new int[]{x, y, d[x][y]});
                        st[x][y] = true;
                    }
                }
            }
            return d[n - 1][m - 1];
        }
    }
}
