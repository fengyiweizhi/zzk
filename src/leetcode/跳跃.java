package leetcode;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/11/5 22:57
 */
public class 跳跃 {
    public static int[][] map = {{-4, -5, -10, -3, 1}, {7, 5, -9, 3, -10}, {10, -2, 6, -10, -4}};
    public static int ans = Integer.MIN_VALUE;
    public static int[] nextRow = {1, 2, 3};
    public static int[] nextCol = {1, 2, 3};

    public static void main(String[] args) {
        dfs(0, 0, 0);
        System.out.print(ans);
    }

    public static void dfs(int i, int j, int sum) {
        sum += map[i][j];
        if (i == map.length - 1 && j == map[0].length - 1) {
            ans = Math.max(ans, sum);
        }
        for (int r : nextRow) {
            if (i + r < map.length) dfs(i + r, j, sum);
        }
        for (int c : nextCol) {
            if (j + c < map[0].length) dfs(i, j + c, sum);
        }
    }
}
