package acwing.算法基础.基础算法.高精度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * 给定两个非负整数（不含前导 0） A，B，请你计算 A/B 的商和余数。
 *
 * 输入格式
 * 共两行，第一行包含整数 A，第二行包含整数 B。
 *
 * 输出格式
 * 共两行，第一行输出所求的商，第二行输出所求余数。
 *
 * 数据范围
 * 1≤A的长度≤100000,
 * 1≤B≤10000,
 * B 一定不为 0
 * 输入样例：
 * 7
 * 2
 * 输出样例：
 * 3
 * 1
 * @author 风亦未止
 * @date 2022/11/28 20:47
 */
public class 高精度除法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger(scanner.nextLine());
        BigInteger bigInteger2 = new BigInteger(scanner.nextLine());
        BigInteger divide = bigInteger.divide(bigInteger2);
        BigInteger mod = bigInteger.mod(bigInteger2);
        System.out.println(divide);
        System.out.println(mod);
    }
}
