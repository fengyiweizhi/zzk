package acwing.算法基础.基础算法.前缀;

import java.util.Scanner;

/**
 * 输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。
 *
 * 对于每个询问输出子矩阵中所有数的和。
 *
 * 输入格式
 * 第一行包含三个整数 n，m，q。
 *
 * 接下来 n 行，每行包含 m 个整数，表示整数矩阵。
 *
 * 接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。
 *
 * 输出格式
 * 共 q 行，每行输出一个询问的结果。
 *
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤200000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 7 2 4
 * 3 6 2 8
 * 2 1 2 3
 * 1 1 2 2
 * 2 1 3 4
 * 1 3 3 4
 * 输出样例：
 * 17
 * 27
 * 21
 * @author 风亦未止
 * @date 2022/11/28 20:53
 */
public class 子矩阵的和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int q=scanner.nextInt();
        int[][] nums=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        int[][] sum=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //相加两个sum时，sum[i-1][j-1]会有两个所以需要减去一个
                sum[i][j]=sum[i-1][j]+sum[i][j-1]+nums[i-1][j-1]-sum[i-1][j-1];
            }
        }
        while(q>0){
            int x1=scanner.nextInt(),y1=scanner.nextInt();
            int x2=scanner.nextInt(),y2=scanner.nextInt();
            //注意减去sum的同时会有两个前sum被减去，所以重复减了，需要补上一个sum
            System.out.println(sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]);
            q--;
        }
    }
}
