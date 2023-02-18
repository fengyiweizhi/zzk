package acwing.每日一题.蓝桥每日一题;

import java.util.Scanner;

/**
 *给定一个由 n 个小写字母构成的字符串。
 *
 * 现在，需要删掉其中的一些字母，使得字符串中不存在连续三个或三个以上的 x。
 *
 * 请问，最少需要删掉多少个字母？
 *
 * 如果字符串本来就不存在连续的三个或三个以上 x，则无需删掉任何字母。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含一个长度为 n 的由小写字母构成的字符串。
 *
 * 输出格式
 * 输出最少需要删掉的字母个数。
 *
 * 数据范围
 * 3≤n≤100
 * 输入样例1：
 * 6
 * xxxiii
 * 输出样例1：
 * 1
 * 输入样例2：
 * 5
 * xxoxx
 * 输出样例2：
 * 0
 * 输入样例3：
 * 10
 * xxxxxxxxxx
 * 输出样例3：
 * 8
 *
 * @author 风亦未止
 * @date 2023/2/17 14:42
 */
public class 字符串删减双指针3768 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int res = 0;
        int cnt = 0;
        for(int i = 0; i < n ;i ++){
            if('x' == s.charAt(i)){
                cnt++;
                if(cnt >= 3){
                    res ++;
                }
            }else if( 'x' != s.charAt(i) && cnt <= 2){
                cnt = 0;
            }
        }
        System.out.println(res);
    }
}
