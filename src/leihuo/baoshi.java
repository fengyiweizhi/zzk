package leihuo;

import java.util.Arrays;

/**
 * @author 风亦未止
 * @date 2023/4/22 15:33
 */
public class baoshi {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param map int整型二维数组 代表地图的二维数组
     * @param a_x int整型 小 A 出生点的 x 坐标
     * @param a_y int整型 小 A 出生点的 y 坐标
     * @param b_x int整型 小 B 出生点的 x 坐标
     * @param b_y int整型 小 B 出生点的 y 坐标
     * @return int整型
     */
    private int[][] q  = new int[200001][2];
    private int hh = 0;
    private int tt = -1;

    private int[][] w;
    private int[] ney = {0 , -1, 0 , 1};
    private int[] nex = {1 , 0, -1, 0};
    private int n;
    private int m;

    public int getEstTime (int[][] map, int a_x, int a_y, int b_x, int b_y) {
        n = map.length;
        m = map[0].length;
        w = new int[n][m];
        for(int i = 0; i < n ; i ++){
            Arrays.fill(w[i], Integer.MAX_VALUE );
        }
        bfs(map,a_x,a_y,b_x,b_y);
        return w[b_x][b_y] == Integer.MAX_VALUE ? -1 :  w[b_x][b_y] / 2;
    }

    public void bfs(int[][] map, int a_x, int a_y, int b_x, int b_y){
        q[++tt] = new int[]{a_x, a_y};
        w[a_x][a_y] = 0;
        while(hh <= tt ){
            int[] t = q[hh++];
            int x = t[0];
            int y = t[1];
            if(x == b_x && y == b_y)return;
            for(int i = 0; i < 4 ; i ++){
                int nx = nex[i] + x;
                int ny = ney[i] + y;
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && map[nx][ny] != -1 ){
                    w[nx][ny] = Math.min(w[x][y] + 1 , w[nx][ny]);
                    map[nx][ny] = -1;
                    q[++tt] = new int[]{nx, ny};
                }
            }
        }
    }
}
