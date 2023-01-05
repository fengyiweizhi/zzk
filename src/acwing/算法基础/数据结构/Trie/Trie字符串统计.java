package acwing.算法基础.数据结构.Trie;

import java.util.Scanner;

/**
 * 高效的存储和查找字符串集合的数据结构
 */

/**
 * 维护一个字符串集合，支持两种操作：
 * <p>
 * I x 向集合中插入一个字符串 x；
 * Q x 询问一个字符串在集合中出现了多少次。
 * 共有 N 个操作，所有输入的字符串总长度不超过 105，字符串仅包含小写英文字母。
 * <p>
 * 输入格式
 * 第一行包含整数 N，表示操作数。
 * <p>
 * 接下来 N 行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。
 * <p>
 * 输出格式
 * 对于每个询问指令 Q x，都要输出一个整数作为结果，表示 x 在集合中出现的次数。
 * <p>
 * 每个结果占一行。
 * <p>
 * 数据范围
 * 1≤N≤2∗104
 * 输入样例：
 * 5
 * I abc
 * Q abc
 * Q ab
 * I ab
 * Q ab
 * 输出样例：
 * 1
 * 0
 * 1
 *
 * @author 风亦未止
 * @date 2022/12/30 16:00
 */
public class Trie字符串统计 {
    public static int[][] son = new int[100010][26];
    public static int[] cnt = new int[100010];
    public static int idx = 0;

    public static void insert(String s) {
        int p = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    public static int query(String s) {
        int p = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            String opt = scanner.next();
            String x = scanner.next();
            if ("I".equals(opt)) {
                insert(x);
            }
            if ("Q".equals(opt)) {
                System.out.println(query(x));
            }
            n--;
        }

    }
}
