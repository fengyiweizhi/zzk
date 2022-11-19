package lanqiao;

import java.util.Scanner;

/**
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 *上图给出了一个数字三角形。从三角形的顶部到底部有很多条不同的路径。对于每条路径，把路径上面的数加起来可以得到一个和，你的任务就是找到最大的和。
 *
 * 路径上的每一步只能从一个数走到下一层和它最近的左边的那个数或者右 边的那个数。此外，向左下走的次数与向右下走的次数相差不能超过 1。
 *
 * 输出27
 * @author 风亦未止
 * @date 2022/1/21 21:42
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[][] b=new int[a][a];
        for (int i=0;i<a;i++){
            for (int j=0;j<=i;j++){
                b[i][j]= scanner.nextInt();
            }
        }
        for (int i=1;i<a;i++){
            for (int j=0;j<=i;j++){
             if(j==0){
                b[i][j]=b[i][j]+b[i-1][0];
             }else if (j==i){
                 b[i][j]=b[i][j]+b[i-1][i-1];
             }else {
                 b[i][j]=Math.max(b[i][j]+b[i-1][j-1],b[i][j]+b[i-1][j]);
             }
            }
        }
        if(a%2==0){
            System.out.println(Math.max(b[a-1][a/2-1],b[a-1][a/2]));
        }else {
            System.out.println(b[a-1][a/2]);
        }
    }
}
