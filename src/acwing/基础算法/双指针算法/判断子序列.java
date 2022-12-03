package acwing.基础算法.双指针算法;

import java.util.Scanner;

/**
 *
 * 给定一个长度为 n 的整数序列 a1,a2,…,an 以及一个长度为 m 的整数序列 b1,b2,…,bm。
 *
 * 请你判断 a 序列是否为 b 序列的子序列。
 *
 * 子序列指序列的一部分项按原有次序排列而得的序列，例如序列 {a1,a3,a5} 是序列 {a1,a2,a3,a4,a5} 的一个子序列。
 *
 * 输入格式
 * 第一行包含两个整数 n,m。
 *
 * 第二行包含 n 个整数，表示 a1,a2,…,an。
 *
 * 第三行包含 m 个整数，表示 b1,b2,…,bm。
 *
 * 输出格式
 * 如果 a 序列是 b 序列的子序列，输出一行 Yes。
 *
 * 否则，输出 No。
 *
 * 数据范围
 * 1≤n≤m≤105,
 * −109≤ai,bi≤109
 * 输入样例：
 * 3 5
 * 1 3 5
 * 1 2 3 4 5
 * 输出样例：
 * Yes
 * @author 风亦未止
 * @date 2022/11/30 21:38
 */
public class 判断子序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] a = new int[n] ;
        int[] b = new int[m];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i]=scanner.nextInt();
        }
        int index1=0;
        int index2=0;
        while(index1<n&&index2<m){
           if(a[index1]==b[index2])index1++;
           index2++;
        }
        System.out.println(index1==n?"Yes":"No");
    }
}
