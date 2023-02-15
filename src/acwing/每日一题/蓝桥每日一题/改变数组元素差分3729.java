package acwing.每日一题.蓝桥每日一题;

import java.util.Scanner;

/**
 *
 * https://www.acwing.com/problem/content/3732/
 *
 *
 * 给定一个空数组 V 和一个整数数组 a1,a2,…,an。
 *
 * 现在要对数组 V 进行 n 次操作。
 *
 * 第 i 次操作的具体流程如下：
 *
 * 从数组 V 尾部插入整数 0。
 * 将位于数组 V 末尾的 ai 个元素都变为 1（已经是 1 的不予理会）。
 * 注意：
 *
 * ai 可能为 0，即不做任何改变。
 * ai 可能大于目前数组 V 所包含的元素个数，此时视为将数组内所有元素变为 1。
 * 请你输出所有操作完成后的数组 V。
 *
 * 输入格式
 * 第一行包含整数 T，表示共有 T 组测试数据。
 *
 * 每组数据第一行包含整数 n。
 *
 * 第二行包含 n 个整数 a1,a2,…,an。
 *
 * 输出格式
 * 每组数据输出一行结果，表示所有操作完成后的数组 V，数组内元素之间用空格隔开。
 *
 * 数据范围
 * 1≤T≤20000,
 * 1≤n≤2×105,
 * 0≤ai≤n,
 * 保证一个测试点内所有 n 的和不超过 2×105。
 *
 * 输入样例：
 * 3
 * 6
 * 0 3 0 0 1 3
 * 10
 * 0 0 0 1 0 5 0 0 0 2
 * 3
 * 0 0 0
 * 输出样例：
 * 1 1 0 1 1 1
 * 0 1 1 1 1 1 0 0 1 1
 * 0 0 0
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/14 15:22
 */
public class 改变数组元素差分3729 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            int m = scanner.nextInt();
            //构造差分数组
            int[] c = new int[m + 2];
            for(int i = 1; i <= m; i ++){
                int num = scanner.nextInt();
                int t = Math.max(1 ,i - num + 1);
                insert(c, t, i, 1);
            }
            for(int i = 1; i < m + 1; i ++){
                c[i] += c[i - 1];
                System.out.print((c[i] > 1 ? 1 : c[i])+ " ");
            }
            System.out.println();
        }
    }

    private static void insert(int[] c, int l , int r, int num){
        c[l] += num;
        c[r+1] -= num;
    }
}
