package acwing.算法基础.数学知识.求组合数;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/890/
 *
 *输入 a,b，求 Cba 的值。
 *
 * 注意结果可能很大，需要使用高精度计算。
 *
 * 输入格式
 * 共一行，包含两个整数 a 和 b。
 *
 * 输出格式
 * 共一行，输出 Cba 的值。
 *
 * 数据范围
 * 1≤b≤a≤5000
 * 输入样例：
 * 5 3
 * 输出样例：
 * 10
 *
 *
 * @author 风亦未止
 * @date 2023/2/15 18:35
 */
public class 求组合数4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        BigInteger Ca = new BigInteger("1");
        BigInteger Cb = new BigInteger("1");
        BigInteger ab = new BigInteger("1");
        BigInteger res = new BigInteger("1");
        for(int i = 2; i <= a; i++){
            Ca = Ca.multiply(BigInteger.valueOf(i));
        }

        for(int i = 2; i <= b; i++){
            Cb = Cb.multiply(BigInteger.valueOf(i));
        }

        for(int i = 2; i <= a - b; i++){
            ab = ab.multiply(BigInteger.valueOf(i));
        }
        System.out.println(res.multiply(Ca).divide(Cb.multiply(ab)));
    }
}
