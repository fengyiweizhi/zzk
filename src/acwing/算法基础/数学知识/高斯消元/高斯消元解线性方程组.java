package acwing.算法基础.数学知识.高斯消元;

import java.util.Scanner;

/**
 *
 * 输入一个包含 n 个方程 n 个未知数的线性方程组。
 *
 * 方程组中的系数为实数。
 *
 * 求解这个方程组。
 *
 * 下图为一个包含 m 个方程 n 个未知数的线性方程组示例：
 *
 * [图片] https://cdn.acwing.com/media/article/image/2019/06/27/19_b30080c698-9a504fc2d5628535be9dcb5f90ef76c6a7ef634a.gif
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含 n+1 个实数，表示一个方程的 n 个系数以及等号右侧的常数。
 *
 * 输出格式
 * 如果给定线性方程组存在唯一解，则输出共 n 行，其中第 i 行输出第 i 个未知数的解，结果保留两位小数。
 *
 * 如果给定线性方程组存在无数解，则输出 Infinite group solutions。
 *
 * 如果给定线性方程组无解，则输出 No solution。
 *
 * 数据范围
 * 1≤n≤100,
 * 所有输入系数以及常数均保留两位小数，绝对值均不超过 100。
 *
 * 输入样例：
 * 3
 * 1.00 2.00 -1.00 -6.00
 * 2.00 1.00 -3.00 -9.00
 * -1.00 -1.00 2.00 7.00
 * 输出样例：
 * 1.00
 * -2.00
 * 3.00
 *
 *
 * @author 风亦未止
 * @date 2023/2/13 17:49
 */
public class 高斯消元解线性方程组 {
    private static double[][] a;
    private static int n;
    //一个很小的数 ， 10的-6次方
    final static double eps = 1e-6;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new double[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n + 1; j ++){
                a[i][j] = scanner.nextDouble();
            }
        }

        int t = Gaussian();

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n + 1; j ++){
        //         System.out.printf("%.2f\t", a[i][j]);
        //     }
        //     System.out.println();
        // }

        if(t == 0){
            for(int i = 0; i < n ; i++){
                System.out.printf("%.2f\n",a[i][n] == -0.00? 0.00:a[i][n]);
            }
        }else if(t == 1){
            System.out.println("Infinite group solutions");
        }else {
            System.out.println("No solution");
        }
    }

    private static int Gaussian() {
        int r, c ;
        for(r = 0 , c = 0; c < n ; c ++){
            int t = r;
            //找x1 的系数较大的那一行放在靠前的一列
            for(int i = r; i < n; i++){
                if(Math.abs(a[i][c]) > Math.abs(a[t][c])){
                    t = i;
                }
            }
            //认为这个数等于0 (小于一个很小的数就认为等于0)
            if(Math.abs(a[t][c]) < eps){
                continue;
            }
            //交换到靠前的一列（将某两行的所有列的数交换）
            for(int i = c; i <= n ; i++){
                double temp = a[t][i];
                a[t][i] = a[r][i];
                a[r][i] = temp;
            }
            //将该行第一个数(在c位置)变为1; 从最后一列的数一次网前÷第一列的数。
            for(int i = n; i >= c; i --){
                a[r][i] /= a[r][c];
            }
            //将该行下面第c列都变为0；
            for(int i = r + 1; i < n; i++){
                //该值不是0,再操作
                if(Math.abs(a[i][c]) > eps){
                    for(int j = n ; j >= c; j-- ){
                        a[i][j] -= a[i][c] * a[r][j];
                    }
                }
            }
            r ++;
        }
        if(r < n){
            for(int i = r ; i < n ; i++){
                // r的下面不等于0
                if(Math.abs(a[i][n]) > eps){
                    return 2; // 无解
                }
            }
            return 1; //有无穷多个解
        }
        for(int i = n - 1; i >= 0 ;i --){
            for(int j = i + 1; j < n; j++){
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        //有唯一解
        return 0;
    }
}
