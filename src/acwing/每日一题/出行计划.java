package acwing.每日一题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4458/
 *
 * 最近西西艾弗岛上出入各个场所都要持有一定时限内的核酸检测阴性证明。
 *
 * 具体来时，如果在 t 时刻做了核酸检测，则经过一段时间后可以得到核酸检测阴性证明。
 *
 * 这里我们假定等待核酸检测结果需要 k 个单位时间，即在 t+k 时刻可以获得结果。
 *
 * 如果一个场所要求持 24 个单位时间内核酸检测结果入内，那么凭上述的核酸检测结果，可以在第 t+k 时刻到第 t+k+23 时刻进入该场所。
 *
 * 小 C 按时间顺序列出接下来的 n 项出行计划，其中第 i 项（1≤i≤n）可以概括为：ti 时刻进入某场所，该场所需持有 ci 个单位时间内的核酸检测结果入内，其中 0<ci≤2×105。
 *
 * 为了合理安排核酸检测时间，试根据小 C 的出行计划，回答如下查询：
 *
 * 如果在 q 时刻做了核酸检测，有多少项出行计划的核酸检测要求可以得到满足？
 * 这样的查询共有 m 个，分别为 q1,q2,⋯,qm；查询之间互不影响。
 *
 * 输入格式
 * 输入的第一行包含空格分隔的三个正整数 n、m 和 k，分别表示出行计划数目、查询个数以及等待核酸检测结果所需时间。
 *
 * 接下来输入 n 行，其中每行包含用空格分隔的两个正整数 ti、ci，表示一项出行计划；出行计划按时间顺序给出，满足 0<t1≤t2≤⋯≤tn≤2×105。
 *
 * 最后输入 m 行，每行仅包含一个正整数 qi，表示一个查询。m 个查询亦按照时间顺序给出，满足 0<q1<q2<⋯<qm≤2×105。
 *
 * 输出格式
 * 输出共 m 行，每行一个整数，表示对应查询的答案。
 *
 * 数据范围
 * 40% 的测试数据满足 0<n,k≤1000、m=1；
 * 70% 的测试数据满足 0<n,m,k≤1000；
 * 全部的测试数据满足 0<n,m,k≤105。
 *
 * 输入样例：
 * 6 2 10
 * 5 24
 * 10 24
 * 11 24
 * 34 24
 * 35 24
 * 35 48
 * 1
 * 2
 * 输出样例：
 * 3
 * 3
 * 样例解释
 * 时刻 1 做检测，可以满足第三、四、六项出行计划；
 *
 * 时刻 2 做检测，可以满足第四、五、六项出行计划。
 *
 * @author 风亦未止
 * @date 2023/1/14 14:18
 */
public class 出行计划 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] f = new int[200010];
        for(int i = 1 ; i <= n ; i++){
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int l = t - k - c + 1, r = t - k;
            if (r >= 1) {
                l = Math.max(1, l);
                r = Math.min(n, r);
                f[l] ++ ;
                f[r + 1] -- ;
            }
        }
        for (int i = 1; i <= 200000; i ++ ) {
            f[i] += f[i - 1];
        }

        while(m -- > 0){
            int q = scanner.nextInt();
            System.out.println(f[q]);
        }
    }
}
