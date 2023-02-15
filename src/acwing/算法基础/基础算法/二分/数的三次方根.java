package acwing.算法基础.基础算法.二分;

import java.util.Scanner;

/**
 *
 * 给定一个浮点数 n，求它的三次方根。
 *
 * 输入格式
 * 共一行，包含一个浮点数 n。
 *
 * 输出格式
 * 共一行，包含一个浮点数，表示问题的解。
 *
 * 注意，结果保留 6 位小数。
 *
 * 数据范围
 * −10000≤n≤10000
 * 输入样例：
 * 1000.00
 * 输出样例：
 * 10.000000
 * @author 风亦未止
 * @date 2022/11/27 23:33
 */
public class 数的三次方根 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nums = scanner.nextDouble();
        double l =- 10000, r = 10000;
        while(r - l > 1e-8){
            double mid =  (l + r ) / 2;
            if(mid * mid * mid >= nums){
                r = mid;
            }else {
                l = mid;
            }
        }
        System.out.println(String.format("%.6f", r));
    }
}
