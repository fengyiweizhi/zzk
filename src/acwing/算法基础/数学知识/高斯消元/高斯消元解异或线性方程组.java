package acwing.算法基础.数学知识.高斯消元;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/886/
 *
 *
 * 输入一个包含 n 个方程 n 个未知数的异或线性方程组。
 *
 * 方程组中的系数和常数为 0 或 1，每个未知数的取值也为 0 或 1。
 *
 * 求解这个方程组。
 *
 * 异或线性方程组示例如下：
 *
 * M[1][1]x[1] ^ M[1][2]x[2] ^ … ^ M[1][n]x[n] = B[1]
 * M[2][1]x[1] ^ M[2][2]x[2] ^ … ^ M[2][n]x[n] = B[2]
 * …
 * M[n][1]x[1] ^ M[n][2]x[2] ^ … ^ M[n][n]x[n] = B[n]
 * 其中 ^ 表示异或(XOR)，M[i][j] 表示第 i 个式子中 x[j] 的系数，B[i] 是第 i 个方程右端的常数，取值均为 0 或 1。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含 n+1 个整数 0 或 1，表示一个方程的 n 个系数以及等号右侧的常数。
 *
 * 输出格式
 * 如果给定线性方程组存在唯一解，则输出共 n 行，其中第 i 行输出第 i 个未知数的解。
 *
 * 如果给定线性方程组存在多组解，则输出 Multiple sets of solutions。
 *
 * 如果给定线性方程组无解，则输出 No solution。
 *
 * 数据范围
 * 1≤n≤100
 * 输入样例：
 * 3
 * 1 1 0 1
 * 0 1 1 0
 * 1 0 0 1
 * 输出样例：
 * 1
 * 0
 * 0
 *
 * @author 风亦未止
 * @date 2023/2/14 17:54
 */
public class 高斯消元解异或线性方程组 {

    private static int[][] a;
    private static int n;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][n + 1];
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j <= n; j++){
                a[i][j] = scanner.nextInt();
            }
        }
        int res = gauss();
        if(res == 0){
            for(int i = 0; i < n; i ++ ){
                System.out.println(a[i][n]);
            }
        }else if(res == 1){
            System.out.println("Multiple sets of solutions");
        }else {
            System.out.println("No solution");
        }
    }

    private static int gauss() {
        int r ,c;
        for( r = c = 0; c < n; c ++){
            int t = r;
            //找第一个数是1的
            for(int i = r; i < n; i++){
                if(a[i][c] == 1){
                    t = i;
                    break;
                }
            }
            if(a[t][c] != 1){
                continue;
            }
            //交换行上每一列的数
            for(int i = c; i <=n; i++ ){
                int temp = a[r][i];
                a[r][i] = a[t][i];
                a[t][i] = temp;
            }

            //下面都变成0
            for(int i = r + 1; i < n; i++){
                if(a[i][c] == 1){
                    for(int j = c; j <=n ; j++){
                        a[i][j] ^= a[r][j];
                    }
                }
            }
            r++;
        }

        if(r < n){
            for(int i = r; i < n ; i ++){
                if(a[i][c] == 1){
                    return 2;
                }
            }
            return 1;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j ++){
                a[i][n] ^= a[i][j] & a[j][n];
            }
        }
        return 0;
    }
}
