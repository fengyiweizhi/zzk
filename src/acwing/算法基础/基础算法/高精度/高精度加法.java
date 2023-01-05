package acwing.算法基础.基础算法.高精度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * 给定两个正整数（不含前导 0），计算它们的和。
 *
 * 输入格式
 * 共两行，每行包含一个整数。
 *
 * 输出格式
 * 共一行，包含所求的和。
 *
 * 数据范围
 * 1≤整数长度≤100000
 * 输入样例：
 * 12
 * 23
 * 输出样例：
 * 35
 * @author 风亦未止
 * @date 2022/11/28 17:11
 */
public class 高精度加法 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger(scanner.nextLine());
        BigInteger bigInteger2 = new BigInteger(scanner.nextLine());
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);
    }
}
