package lanqiao.测评系统;

import java.util.Scanner;

/**
 *问题描述
 * 　　共有n种图案的印章，每种图案的出现概率相同。小A买了m张印章，求小A集齐n种印章的概率。
 * 输入格式
 * 　　一行两个正整数n和m
 * 输出格式
 * 　　一个实数P表示答案，保留4位小数。
 * 样例输入
 * 2 3
 * 样例输出
 * 0.7500
 * 数据规模和约定
 * 　　1≤n，m≤20
 *
 *
 * @author 风亦未止
 * @date 2023/3/30 17:43
 */
public class 印章 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(m < n) {
            System.out.println(String.format("%.4f",0.0000));
            return;
        }
        System.out.print(String.format("%.4f",Math.abs(couponCollector(n, m))));
    }

    public static double couponCollector(int n, int m) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(-1, i + 1) * binomial(n, i) * Math.pow(i * 1.0 / n, m);
        }
        return sum;
    }

    public static int binomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        int b = 1;
        for (int i = 1, m = n; i <= k; i++, m--) {
            b = b * m / i;
        }
        return b;
    }


}
