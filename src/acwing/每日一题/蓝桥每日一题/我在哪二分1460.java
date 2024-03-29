package acwing.每日一题.蓝桥每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1462/
 *
 *
 *农夫约翰出门沿着马路散步，但是他现在发现自己可能迷路了！
 *
 * 沿路有一排共 N 个农场。
 *
 * 不幸的是农场并没有编号，这使得约翰难以分辨他在这条路上所处的位置。
 *
 * 然而，每个农场都沿路设有一个彩色的邮箱，所以约翰希望能够通过查看最近的几个邮箱的颜色来唯一确定他所在的位置。
 *
 * 每个邮箱的颜色用 A..Z 之间的一个字母来指定，所以沿着道路的 N 个邮箱的序列可以用一个长为 N 的由字母 A..Z 组成的字符串来表示。
 *
 * 某些邮箱可能会有相同的颜色。
 *
 * 约翰想要知道最小的 K 的值，使得他查看任意连续 K 个邮箱序列，他都可以唯一确定这一序列在道路上的位置。
 *
 * 例如，假设沿路的邮箱序列为 ABCDABC 。
 *
 * 约翰不能令 K=3，因为如果他看到了 ABC，则沿路有两个这一连续颜色序列可能所在的位置。
 *
 * 最小可行的 K 的值为 K=4，因为如果他查看任意连续 4 个邮箱，那么可得到的连续颜色序列可以唯一确定他在道路上的位置。
 *
 * 输入格式
 * 输入的第一行包含 N，第二行包含一个由 N 个字符组成的字符串，每个字符均在 A..Z 之内。
 *
 * 输出格式
 * 输出一行，包含一个整数，为可以解决农夫约翰的问题的最小 K 值。
 *
 * 数据范围
 * 1≤N≤100
 * 输入样例：
 * 7
 * ABCDABC
 * 输出样例：
 * 4
 * @author 风亦未止
 * @date 2023/2/15 14:56
 */
public class 我在哪二分1460 {
    private static   HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();

        int l = 1 , r = n;
        while(l < r){
            int mid = (l + r) >> 1;
            if(check(mid, str)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

    private static boolean check(int mid, String str){
        int length = str.length();
        for(int i = 0; i + mid - 1 < length ; i ++){
            String s = str.substring(i , mid + i);
            if(set.contains(s)){
                return false;
            }
            set.add(s);
        }
        return true;
    }
}
