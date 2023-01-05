package acwing.算法基础.数据结构.堆;

import java.util.Scanner;

/**
 * 输入一个长度为 n 的整数数列，从小到大输出前 m 小的数。
 * <p>
 * 输入格式
 * 第一行包含整数 n 和 m。
 * <p>
 * 第二行包含 n 个整数，表示整数数列。
 * <p>
 * 输出格式
 * 共一行，包含 m 个整数，表示整数数列中前 m 小的数。
 * <p>
 * 数据范围
 * 1≤m≤n≤105，
 * 1≤数列中元素≤109
 * 输入样例：
 * 5 3
 * 4 5 1 3 2
 * 输出样例：
 * 1 2 3
 *
 * @author 风亦未止
 * @date 2023/1/4 20:56
 */
public class 堆排序 {
    public static int[] h = new int[100010];
    public static int size;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        size = n;
        for (int i = 1; i <= n; i++) {
            h[i] = scanner.nextInt();
        }
        for (int i = n / 2; i >= 1; i--) {
            down(i);
        }
        while (m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size];
            down(1);
            size--;
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
            int temp = h[i];
            h[i] = h[u];
            h[u] = temp;
            down(u);
        }
    }
}
