package acwing.算法基础.数据结构.双链表;

import java.util.Scanner;

/**
 * 实现一个双链表，双链表初始为空，支持 5 种操作：
 * <p>
 * 在最左侧插入一个数；
 * 在最右侧插入一个数；
 * 将第 k 个插入的数删除；
 * 在第 k 个插入的数左侧插入一个数；
 * 在第 k 个插入的数右侧插入一个数
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。
 * <p>
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 * <p>
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * <p>
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * <p>
 * L x，表示在链表的最左端插入数 x。
 * R x，表示在链表的最右端插入数 x。
 * D k，表示将第 k 个插入的数删除。
 * IL k x，表示在第 k 个插入的数左侧插入一个数。
 * IR k x，表示在第 k 个插入的数右侧插入一个数。
 * 输出格式
 * 共一行，将整个链表从左到右输出。
 * <p>
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 *
 * @author 风亦未止
 * @date 2022/12/3 23:45
 */
public class 双链表 {
    public static int[] val = new int[100010];
    public static int[] l = new int[100010];
    public static int[] r = new int[100010];
    public static int index = 0;

    public static void init() {
        r[0] = 1;
        l[1] = 0;
        index = 2;
    }

    //一个操作,在k右边插入
    public static void add(int k, int x) {
        val[index] = x;
        r[index] = r[k];
        l[r[k]] = index;
        r[k] = index;
        l[index] = k;
        index++;
    }

    public static void delete(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        int m = scanner.nextInt();
        while (m > 0) {
            String op = scanner.next();
            if ("L".equals(op)) {
                int x = scanner.nextInt();
                add(0,x);
            }
            if ("R".equals(op)) {
                int x = scanner.nextInt();
                add(l[1],x);
            }
            if ("D".equals(op)) {
                int k = scanner.nextInt();
                delete(k + 1);
            }
            if ("IL".equals(op)) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                add(l[k + 1], x);
            }
            if ("IR".equals(op)) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                add(k + 1, x);
            }
            m--;
        }
        //i!=1,因为最右边的下标是1
        for(int i=r[0];i!=1;i=r[i]){
            System.out.print(val[i]+" ");
        }

    }
}
