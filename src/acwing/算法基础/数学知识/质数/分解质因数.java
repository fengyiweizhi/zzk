package acwing.算法基础.数学知识.质数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/869/
 *
 * 给定 n 个正整数 ai，将每个数分解质因数，并按照质因数从小到大的顺序输出每个质因数的底数和指数。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个正整数 ai。
 *
 * 输出格式
 * 对于每个正整数 ai，按照从小到大的顺序输出其分解质因数后，每个质因数的底数和指数，每个底数和指数占一行。
 *
 * 每个正整数的质因数全部输出完毕后，输出一个空行。
 *
 * 数据范围
 * 1≤n≤100,
 * 2≤ai≤2×109
 * 输入样例：
 * 2
 * 6
 * 8
 * 输出样例：
 * 2 1
 * 3 1
 *
 * 2 3
 *
 * @author 风亦未止
 * @date 2023/1/25 23:28
 */
public class 分解质因数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int m = scanner.nextInt();
            divide(m);
            System.out.println();
        }
    }

    private static void divide(int m) {
        //从小到大枚举数 ， 当枚举到 i 时， 已经把 2 ~ i-1 的质因子除干净了
        // m 当中最多包含一个大于sqrt(m) 的质因子·
        for(int i = 2; i <= m / i; i++ ){
            if(m % i == 0){ // 成立时 i 一定是质数
                int count = 0;
                while(m % i == 0){
                    m /= i;
                    count++;
                }
                System.out.println(i + " " + count);
            }
        }
        if(m > 1){
            System.out.println(m + " " + 1);
        }
    }
}
