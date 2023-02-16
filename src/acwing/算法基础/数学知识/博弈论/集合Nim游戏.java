package acwing.算法基础.数学知识.博弈论;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * https://www.acwing.com/problem/content/895/
 *
 *给定 n 堆石子以及一个由 k 个不同正整数构成的数字集合 S。
 *
 * 现在有两位玩家轮流操作，每次操作可以从任意一堆石子中拿取石子，每次拿取的石子数量必须包含于集合 S，最后无法进行操作的人视为失败。
 *
 * 问如果两人都采用最优策略，先手是否必胜。
 *
 * 输入格式
 * 第一行包含整数 k，表示数字集合 S 中数字的个数。
 *
 * 第二行包含 k 个整数，其中第 i 个整数表示数字集合 S 中的第 i 个数 si。
 *
 * 第三行包含整数 n。
 *
 * 第四行包含 n 个整数，其中第 i 个整数表示第 i 堆石子的数量 hi。
 *
 * 输出格式
 * 如果先手方必胜，则输出 Yes。
 *
 * 否则，输出 No。
 *
 * 数据范围
 * 1≤n,k≤100,
 * 1≤si,hi≤10000
 * 输入样例：
 * 2
 * 2 5
 * 3
 * 2 4 7
 * 输出样例：
 * Yes
 *
 * @author 风亦未止
 * @date 2023/2/16 17:26
 */
public class 集合Nim游戏 {
    private static int M  = 10010;
    private static int N = 101;
    private static int n;
    private static int m;
    private static int[] s = new int[N];
    private static int[] f = new int[M];

    public static void main(String[] args) {
        Arrays.fill(f, -1);
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        for(int i = 0; i < m; i++){
           s[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        int res = 0;
        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();
            res ^= sg(x);
        }
        System.out.println( res == 0 ? "No" : "Yes");
    }

    private static int sg(int x) {
        if(f[x] != -1 ){
            return f[x];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < m ; i++) {
            int sum = s[i];
            //如果要拿的石子数量少于 该堆石子的数量x
            if(x >= sum){
                set.add(sg( x - sum));
            }
        }
        for(int i = 0; ; i++ ){
            if(!set.contains(i)){
                f[x] = i;
                return i;
            }
        }
    }
}
