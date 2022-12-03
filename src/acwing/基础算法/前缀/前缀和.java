package acwing.基础算法.前缀;

import java.util.Scanner;

/**
 *
 * 输入一个长度为 n 的整数序列。
 *
 * 接下来再输入 m 个询问，每个询问输入一对 l,r。
 *
 * 对于每个询问，输出原序列中从第 l 个数到第 r 个数的和。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 第二行包含 n 个整数，表示整数数列。
 *
 * 接下来 m 行，每行包含两个整数 l 和 r，表示一个询问的区间范围。
 *
 * 输出格式
 * 共 m 行，每行输出一个询问的结果。
 *
 * 数据范围
 * 1≤l≤r≤n,
 * 1≤n,m≤100000,
 * −1000≤数列中元素的值≤1000
 * 输入样例：
 * 5 3
 * 2 1 3 6 4
 * 1 2
 * 1 3
 * 2 4
 * 输出样例：
 * 3
 * 6
 * 10
 * @author 风亦未止
 * @date 2022/11/28 20:52
 */
public class 前缀和 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m=scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int[] sum=new int[n+1];
        for(int i=1;i<n+1;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        while(m>0){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            System.out.println(sum[r]-sum[l-1]);
            m--;
        }
    }
}
