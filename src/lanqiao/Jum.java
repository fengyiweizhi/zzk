package lanqiao;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2021/12/5 17:44
 */
public class Jum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  x = scanner.nextInt();
        int  y = scanner.nextInt();
        int[][] arr = new int[x][y];
        for(int i = 0;i<x;i++) {
            for(int j = 0;j<y;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result = dfs(arr,0,0);
        System.out.println(result);
    }

    static int dfs(int[][]arr, int x, int y) {
        if(x==arr.length-1 && y == arr[0].length-1) {
            return arr[x][y];
        }

        int[]a = new int[] {1,2,3,0,0,0,1,1,2};
        int[]b = new int[] {0,0,0,1,2,3,1,2,1};

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<a.length;i++) {

            if(x+a[i]>=arr.length || y+b[i]>=arr[0].length) {
                continue;
            }
            max = Math.max(dfs(arr,x+a[i], y+b[i]), max);
        }
        return max+ arr[x][y];
    }
}
