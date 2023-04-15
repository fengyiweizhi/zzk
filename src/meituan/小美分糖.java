package meituan;

import java.util.Scanner;

/**
 * 小美分糖
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 某一天，小美从商店买了两种糖果，分别买了a个和b个，要分给班上n个小朋友。为了不浪费，每块糖果都得恰好分到一个小朋友。
 * 另外，两种糖果一起吃的话味道其实并不好，所以每一个小朋友都只能得到其中一种糖果。
 *
 * 小美希望分得最少糖果的那个小朋友能得到尽量多的糖果。小美的任务是求得这个数量是多少。
 *
 *
 *
 * 输入描述
 * 第一行一个正整数T，表示有T组数据。
 *
 * 对于每一组数据，输入一行n,a,b，中间用空格隔开。
 *
 * 1≤a,b≤10000,   2≤n≤a+b,  1≤T≤100
 *
 * 输出描述
 * 对于每一组数据，输出仅一行一个整数，表示答案。
 *
 *
 * 样例输入
 * 2
 * 5 2 3
 * 4 7 10
 * 样例输出
 * 1
 * 3
 *
 * 提示
 * 第一组数据，每个小朋友都恰好分得一个糖果；
 *
 * 第二组数据，可以分成：（3个第一种，4个第一种，5个第二种，5个第二种），这样第一个小朋友分得最少，没有其他方案使得分得最少的那个小朋友的糖果数量更大。
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 *
 * @author 风亦未止
 * @date 2023/4/15 10:37
 */
public class 小美分糖 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while(m -- > 0){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = Math.min(a, b);
            int l = 0, r = c;
            while(l < r){
                int mid = l + (r - l) / 2;



            }



        }




    }
}
