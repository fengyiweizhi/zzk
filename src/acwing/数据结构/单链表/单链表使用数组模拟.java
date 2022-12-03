package acwing.数据结构.单链表;

import java.util.Scanner;

/**
 * 实现一个单链表，链表初始为空，支持三种操作：
 * <p>
 * 向链表头插入一个数；
 * 删除第 k 个插入的数后面的数；
 * 在第 k 个插入的数后插入一个数。
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。
 * <p>
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 * <p>
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * <p>
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * <p>
 * H x，表示向链表头插入一个数 x。
 * D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
 * I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。
 * 输出格式
 * 共一行，将整个链表从头到尾输出。
 * <p>
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 * <p>
 * 输入样例：
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 6 4 6 5
 *
 * @author 风亦未止
 * @date 2022/12/3 22:43
 */
public class 单链表使用数组模拟 {
    public static int head = -1;//头节点的下标
    public static int idx = 0;//当前已经用到的点下标
    public static int[] e = new int[100010];//e[i] 下标i的值
    public static int[] ne = new int[100010];//ne[i] 下标i的下一个下标

    /**
     * 在头节点插入
     */
    public static void add_head(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    /**
     * 在k的下标后插入
     */
    public static void insert(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    /**
     * 删除第k下标后的节点
     */
    public static void delete(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m > 0) {
            String op = scanner.next();
            if ("H".equals(op)) {
                int val = scanner.nextInt();
                add_head(val);
            }
            if ("D".equals(op)) {
                int k = scanner.nextInt();
                if (k == 0) {
                    head = ne[head];
                } else {
                    delete(k - 1);
                }

            }
            if ("I".equals(op)) {
                int k = scanner.nextInt();
                int val = scanner.nextInt();
                insert(k - 1, val);
            }
            m--;
        }
        int index = head;
        while (index != -1) {
            System.out.print(e[index] + " ");
            index = ne[index];
        }
    }

}
