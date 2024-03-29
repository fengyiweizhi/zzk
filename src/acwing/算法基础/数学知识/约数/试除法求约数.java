package acwing.算法基础.数学知识.约数;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/871/
 *
 * 给定 n 个正整数 ai，对于每个整数 ai，请你按照从小到大的顺序输出它的所有约数。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个整数 ai。
 *
 * 输出格式
 * 输出共 n 行，其中第 i 行输出第 i 个整数 ai 的所有约数。
 *
 * 数据范围
 * 1≤n≤100,
 * 2≤ai≤2×109
 * 输入样例：
 * 2
 * 6
 * 8
 * 输出样例：
 * 1 2 3 6
 * 1 2 4 8
 *
 *
 * @author 风亦未止
 * @date 2023/2/11 15:36
 */
public class 试除法求约数 {
    private static PriorityQueue<Integer> get(int m ){
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for(int i = 1; i <= m / i;i ++){
            if(m % i == 0){
                integers.offer(i);
                if(i != m / i){
                    integers.offer( m / i);
                }
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int m = scanner.nextInt();
            PriorityQueue<Integer> integers = get(m);
            while(!integers.isEmpty()){
                System.out.print( integers.poll() +" ");
            }
            System.out.println();
        }

    }
}
