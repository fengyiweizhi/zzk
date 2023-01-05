package acwing.算法基础.数据结构.并查集;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/839/
 * <p>
 * 给定一个包含 n 个点（编号为 1∼n）的无向图，初始时图中没有边。
 * <p>
 * 现在要进行 m 个操作，操作共有三种：
 * <p>
 * C a b，在点 a 和点 b 之间连一条边，a 和 b 可能相等；
 * Q1 a b，询问点 a 和点 b 是否在同一个连通块中，a 和 b 可能相等；
 * Q2 a，询问点 a 所在连通块中点的数量；
 * 输入格式
 * 第一行输入整数 n 和 m。
 * <p>
 * 接下来 m 行，每行包含一个操作指令，指令为 C a b，Q1 a b 或 Q2 a 中的一种。
 * <p>
 * 输出格式
 * 对于每个询问指令 Q1 a b，如果 a 和 b 在同一个连通块中，则输出 Yes，否则输出 No。
 * <p>
 * 对于每个询问指令 Q2 a，输出一个整数表示点 a 所在连通块中点的数量
 * <p>
 * 每个结果占一行。
 * <p>
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 5 5
 * C 1 2
 * Q1 1 2
 * Q2 1
 * C 2 5
 * Q2 5
 * 输出样例：
 * Yes
 * 2
 * 3
 *
 * @author 风亦未止
 * @date 2023/1/2 15:46
 */
public class 连通块中点的数量 {
    public static int[] point = new int[100010];
    public static int[] size = new int[100010];

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
            size[i] = 1;
        }
        int m = scanner.nextInt();
        while (m-- > 0) {
            String opt = scanner.next();
            if ("C".equals(opt)) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                if (find(num1) == find(num2)) continue;
                //让num1的祖宗节点 = num2的祖宗节点
                size[find(num2)] += size[find(num1)];
                point[find(num1)] = point[find(num2)];
            }
            if ("Q1".equals(opt)) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                System.out.println(find(num1) == find(num2) ? "Yes" : "No");
            }
            if ("Q2".equals(opt)) {
                int num1 = scanner.nextInt();
                System.out.println(size[find(num1)]);
            }
        }

    }
}
