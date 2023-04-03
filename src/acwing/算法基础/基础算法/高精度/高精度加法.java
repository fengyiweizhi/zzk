package acwing.算法基础.基础算法.高精度;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BigInteger bigInteger = new BigInteger(scanner.nextLine());
//        BigInteger bigInteger2 = new BigInteger(scanner.nextLine());
//        BigInteger add = bigInteger.add(bigInteger2);
//        System.out.println(add);
//    }

    //压9位
    private static List<Integer> add(List<Integer> a, List<Integer> b){
        if(b.size() > a .size())return add(b , a);
        List<Integer> c = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < a.size(); i ++){
            t += a.get(i);
            //位数相加
            if(i < b.size()) t += b.get(i);
            c.add( t % 1000000000);
            //进位
            t /= 1000000000;
        }
        if(t != 0)c.add(t);
        return c;
    }

    //压9位
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        String m = scanner.next();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i = n.length() - 1 , s = 0 , t = 1 , c = 0; i >= 0 ; i -- ){
            s += t * (n.charAt(i) - '0');
            t *= 10;
            c ++;
            //到达9位 或者 是最高位时 添加到数组。
            if(c == 9 || i == 0){
                a.add(s);
                s = 0;
                t = 1;
                c = 0;
            }
        }
        for(int i = m.length() - 1 , s = 0 , t = 1 , c = 0; i >= 0 ; i -- ){
            s += t * (m.charAt(i) - '0');
            t *= 10;
            c ++;
            //到达9位 或者 是最高位时 添加到数组。
            if(c == 9 || i == 0){
                b.add(s);
                s = 0;
                t = 1;
                c = 0;
            }
        }
        List<Integer> c = add(a, b);
        //第一个不用前面是否补0
        System.out.print(c.get(c.size() - 1));
        //后面需要补前导0 ，保证是9位数
        for(int i = c.size() - 2; i >= 0; i --){
            System.out.print(String.format("%09d",c.get(i)));
        }
    }
}
