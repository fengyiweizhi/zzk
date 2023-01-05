package acwing.算法基础.数据结构.并查集;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/838/
 * <p>
 * <p>
 * 一共有 n 个数，编号是 1∼n，最开始每个数各自在一个集合中。
 * <p>
 * 现在要进行 m 个操作，操作共有两种：
 * <p>
 * M a b，将编号为 a 和 b 的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
 * Q a b，询问编号为 a 和 b 的两个数是否在同一个集合中；
 * 输入格式
 * 第一行输入整数 n 和 m。
 * <p>
 * 接下来 m 行，每行包含一个操作指令，指令为 M a b 或 Q a b 中的一种。
 * <p>
 * 输出格式
 * 对于每个询问指令 Q a b，都要输出一个结果，如果 a 和 b 在同一集合内，则输出 Yes，否则输出 No。
 * <p>
 * 每个结果占一行。
 * <p>
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * M 1 2
 * M 3 4
 * Q 1 2
 * Q 1 3
 * Q 3 4
 * 输出样例：
 * Yes
 * No
 * Yes
 *
 * @author 风亦未止
 * @date 2023/1/1 22:09
 */
public class 合并集合 {
    public static int[] point = new int[100010];

    //查找根节点+路径压缩 - 在查询父节点的时候，直接让x的父节点 = 祖宗节点
    public static int find(int x) {
        if (point[x] != x) {
            point[x] = find(point[x]);
        }
        return point[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            point[i] = i;
        }
        int m = scanner.nextInt();
        while (m > 0) {
            String opt = scanner.next();
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            if ("M".equals(opt)) {
                //让num1的祖宗节点 = num2的祖宗节点
                point[find(num1)] = point[find(num2)];
            }
            if ("Q".equals(opt)) {
                System.out.println(find(num1) == find(num2) ? "Yes" : "No");
            }
            m--;
        }

    }
}
