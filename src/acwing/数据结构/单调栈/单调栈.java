package acwing.数据结构.单调栈;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * 给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
 *
 * 输入格式
 * 第一行包含整数 N，表示数列长度。
 *
 * 第二行包含 N 个整数，表示整数数列。
 *
 * 输出格式
 * 共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。
 *
 * 数据范围
 * 1≤N≤105
 * 1≤数列中元素≤109
 * 输入样例：
 * 5
 * 3 4 2 7 5
 * 输出样例：
 * -1 3 -1 2 2
 *
 *
 * @author 风亦未止
 * @date 2022/12/5 21:57
 */
public class 单调栈 {
    public static int[] stk = new int[110];
    public static int tt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i < n; i++){
            int x = scanner.nextInt();
            while (tt!=0&&stk[tt]>=x){
                tt--;
            }
            if(x>stk[tt]){
                System.out.print(tt==0?-1:stk[tt]+" ");
                stk[++tt]=x;
            }
        }
    }
}
