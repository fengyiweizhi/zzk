package acwing.算法基础.数学知识.求组合数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/887/
 *给定 n 组询问，每组询问给定两个整数 a，b，请你输出 Cbamod(109+7) 的值。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一组 a 和 b。
 *
 * 输出格式
 * 共 n 行，每行输出一个询问的解。
 *
 * 数据范围
 * 1≤n≤10000,
 * 1≤b≤a≤2000
 * 输入样例：
 * 3
 * 3 1
 * 5 3
 * 2 2
 * 输出样例：
 * 3
 * 10
 * 1
 *
 *
 * @author 风亦未止
 * @date 2023/2/14 22:49
 */
public class 求组合数1 {
    private static int N = 2010;
    private static int[][] c = new int[N][N];
    private static int mod = 1000000007;

    //范围较小，可递推
    private static void init(){
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j <= i; j++ ){
                if(j == 0){
                    c[i][j] = 1;
                }else{
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
                }
            }
        }

    }


    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c[a][b]);
        }

    }
}
