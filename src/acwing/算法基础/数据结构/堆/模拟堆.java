package acwing.算法基础.数据结构.堆;

import java.util.Scanner;

/**
 * 维护一个集合，初始时集合为空，支持如下几种操作：
 * <p>
 * I x，插入一个数 x；
 * PM，输出当前集合中的最小值；
 * DM，删除当前集合中的最小值（数据保证此时的最小值唯一）；
 * D k，删除第 k 个插入的数；
 * C k x，修改第 k 个插入的数，将其变为 x；
 * 现在要进行 N 次操作，对于所有第 2 个操作，输出当前集合的最小值。
 * <p>
 * 输入格式
 * 第一行包含整数 N。
 * <p>
 * 接下来 N 行，每行包含一个操作指令，操作指令为 I x，PM，DM，D k 或 C k x 中的一种。
 * <p>
 * 输出格式
 * 对于每个输出指令 PM，输出一个结果，表示当前集合中的最小值。
 * <p>
 * 每个结果占一行。
 * <p>
 * 数据范围
 * 1≤N≤105
 * −109≤x≤109
 * 数据保证合法。
 * <p>
 * 输入样例：
 * 8
 * I -10
 * PM
 * I -10
 * D 1
 * C 2 8
 * I 6
 * PM
 * DM
 * 输出样例：
 * -10
 * 6
 *
 * @author 风亦未止
 */
public class 模拟堆 {
    public static int[] h = new int[100010];
    public static int[] ph = new int[100010];
    public static int[] hp = new int[100010];
    public static int size = 0;
    public static int m = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String op = scanner.next();
            if ("I".equals(op)) {
                int x = scanner.nextInt();
                size++;
                m++;
                h[size] = x;
                ph[m] = size;
                hp[size] = m;
                up(size);
            }
            if ("PM".equals(op)) {
                System.out.println(h[1]);
            }
            if ("DM".equals(op)) {
                swap(1, size);
                size--;
                down(1);
            }
            if ("D".equals(op)) {
                int k = scanner.nextInt();
                int tem = ph[k];
                swap(tem, size);
                size--;
                down(tem);
                up(tem);
            }

            if ("C".equals(op)) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                int tem = ph[k];
                h[tem] = x;
                down(tem);
                up(tem);
            }
        }
    }

    public static void swap(int i, int j) {
        int phtemp = ph[hp[i]];
        ph[hp[i]] = ph[hp[j]];
        ph[hp[j]] = phtemp;

        int hptemp = hp[i];
        hp[i] = hp[j];
        hp[j] = hptemp;

        int htemp = h[i];
        h[i] = h[j];
        h[j] = htemp;
    }

    public static void up(int i) {
        while (i / 2 > 0 && h[i / 2] > h[i]) {
            swap(i / 2, i);
            i /= 2;
        }
    }


    public static void down(int i) {
        int u = i;
        if (2 * i <= size && h[2 * i] < h[u]) {
            u = 2 * i;
        }
        if (2 * i + 1 <= size && h[2 * i + 1] < h[u]) {
            u = 2 * i + 1;
        }
        if (u != i) {
            swap(u, i);
            down(u);
        }
    }
}
