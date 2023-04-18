package 杂题;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 *
 * @author 风亦未止
 * @date 2023/3/19 20:59
 */
public class mimiyo {
    private static char[][] c;
    private static boolean[][] std;
    private static int n ;
    private static int m;
    private static int[][] queue = new int[100001][2];
    private static int hh = 0;
    private static int tt = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c = new char[n][m];
        std = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String s = scanner.next();
            for(int j = 0; j < s.length(); j++){
                c[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < n; i ++){
            for(int j = 0; j < m ; j ++){
                if(!std[i][j]){
                    cnt ++;
                    bfs(i, j , 1);
                }
            }
        }
        for(int i = 0; i < n ; i++){
            Arrays.fill(std[i] , false);
        }
        int count = 0;
        for(int i = 0 ; i < n; i ++){
            for(int j = 0; j < m ; j ++){
                if(!std[i][j]){
                    count ++;
                    bfs(i, j , 2);
                }
            }
        }
        System.out.println(cnt - count);
    }
    public static  void bfs(int i, int j , int flag ){
        queue[++tt] = new int[]{i , j};
        char color = c[i][j];
        int[] x = {0 ,1 ,-1 ,0};
        int[] y = {1 ,0 ,0 ,-1};
        while(hh <= tt){
            int[] t = queue[hh++];
            std[t[0]][t[1]] = true;
            for(int k = 0 ; k < 4 ; k++){
                int nex = t[0] + x[k];
                int ney = t[1] + y[k];
                if(nex >= 0 && nex < n && ney >= 0 && ney < m &&  !std[nex][ney]){
                    if(flag == 1 && c[nex][ney] == color){
                        queue[++tt] = new int[]{nex, ney};
                    }else if(flag == 2 && (color == 'G' || color == 'B') && (c[nex][ney] == 'G' || c[nex][ney] == 'B')){
                        queue[++tt] = new int[]{nex, ney};
                    }else if(flag == 2 && color == 'R' && c[nex][ney] == color){
                        queue[++tt] = new int[]{nex, ney};
                    }
                }
            }
        }
    }
}
