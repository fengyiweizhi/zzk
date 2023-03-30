package lanqiao.测评系统;

import java.util.Scanner;

/**
 * 　给定一个1～N的排列a[i]，每次将相邻两个数相加，得到新序列，再对新序列重复这样的操作，显然每次得到的序列都比上一次的序列长度少1，最终只剩一个数字。
 * 　　例如:
 * 　　3 1 2 4
 * 　　4 3 6
 * 　　7 9
 * 　　16
 * 　　现在如果知道N和最后得到的数字sum，请求出最初序列a[i]，为1～N的一个排列。若有多种答案，则输出字典序最小的那一个。数据保证有解。
 *
 *  输入格式
 * 　　第1行为两个正整数n，sum
 * 输出格式
 * 　　一个1～N的一个排列
 * 样例输入
 * 4 16
 * 样例输出
 * 3 1 2 4
 * 数据规模和约定
 * 　　0<n<=10
 * @author 风亦未止
 * @date 2023/3/30 20:03
 */
public class 数字游戏 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] res = new int[m];



        for(int r : res){
            System.out.print(r + " ");
        }
    }


}
