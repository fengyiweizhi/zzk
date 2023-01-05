package acwing.算法基础.基础算法.高精度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * 给定两个非负整数（不含前导 0） A 和 B，请你计算 A×B 的值。
 *
 * 输入格式
 * 共两行，第一行包含整数 A，第二行包含整数 B。
 *
 * 输出格式
 * 共一行，包含 A×B 的值。
 *
 * 数据范围
 * 1≤A的长度≤100000,
 * 0≤B≤10000
 * 输入样例：
 * 2
 * 3
 * 输出样例：
 * 6
 * @author 风亦未止
 * @date 2022/11/28 20:33
 */
public class 高精度乘法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger(scanner.nextLine());
        BigInteger bigInteger2 = new BigInteger(scanner.nextLine());
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);
    }
}
