package acwing.算法基础.数据结构.KMP;

import java.io.*;
import java.util.Scanner;

/**
 * 给定一个字符串 S，以及一个模式串 P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 * <p>
 * 模式串 P 在字符串 S 中多次作为子串出现。
 * <p>
 * 求出模式串 P 在字符串 S 中所有出现的位置的起始下标。
 * <p>
 * 输入格式
 * 第一行输入整数 N，表示字符串 P 的长度。
 * <p>
 * 第二行输入字符串 P。
 * <p>
 * 第三行输入整数 M，表示字符串 S 的长度。
 * <p>
 * 第四行输入字符串 S。
 * <p>
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从 0 开始计数），整数之间用空格隔开。
 * <p>
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 输入样例：
 * 3
 * aba
 * 5
 * ababa
 * 输出样例：
 * 0 2
 *
 * @author 风亦未止
 * @date 2022/12/7 21:34
 */
public class KMP字符串 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        String p = scanner.next();
        char[] sp = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            sp[i] = p.charAt(i - 1);
        }

        int m = scanner.nextInt();
        String s = scanner.next();
        char[] ss = new char[m + 1];
        for (int i = 1; i <= m; i++) {
            ss[i] = s.charAt(i - 1);
        }

        int[] next = new int[n + 1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && sp[i] != sp[j + 1]) {
                j = next[j];
            }
            if (sp[i] == sp[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && sp[j + 1] != ss[i]) {
                j = next[j];
            }
            if (sp[j + 1] == ss[i]) {
                j++;
            }
            if (j == n) {
                bw.write((i - n ) + " ");
                j = next[j];
            }
        }
        bw.flush();
        bw.close();
    }
    //这里超时了-普通算法
    /**
     *
     * public static void main(String[] args) throws IOException {
     *         Scanner scanner = new Scanner(System.in);
     *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     *         int m = scanner.nextInt();
     *         String p = scanner.next();
     *         int n = scanner.nextInt();
     *         String s = scanner.next();
     *         int i = 0;
     *         int j = 0;
     *         int length = 0;
     *         while (i < m && j < n) {
     *             if (p.charAt(i) == s.charAt(j)) {
     *                 i++;
     *                 j++;
     *                 length++;
     *             } else {
     *                 //回溯
     *                 i = 0;
     *                 j = j - i +1;
     *             }
     *             if(length==m){
     *                 j = j - i +1;
     *                 i = 0;
     *                 length = 0;
     *                 bw.write((j-1)+" ");
     *             }
     *         }
     *         bw.close();
     *
     *     }
     *
     */

}
