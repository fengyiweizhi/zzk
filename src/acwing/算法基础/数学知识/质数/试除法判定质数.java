package acwing.算法基础.数学知识.质数;

import java.util.Scanner;

/**
 * 给定 n 个正整数 ai，判定每个数是否是质数。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个正整数 ai。
 *
 * 输出格式
 * 共 n 行，其中第 i 行输出第 i 个正整数 ai 是否为质数，是则输出 Yes，否则输出 No。
 *
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤231−1
 * 输入样例：
 * 2
 * 2
 * 6
 * 输出样例：
 * Yes
 * No
 *
 *
 * @author 风亦未止
 * @date 2023/1/25 21:56
 */
public class 试除法判定质数 {
    //判断质数 - 试除法
    private static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i = 2 ; i <= x / i ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int x = scanner.nextInt();
            System.out.println(isPrime(x) ? "Yes" : "No");
        }
    }
}
