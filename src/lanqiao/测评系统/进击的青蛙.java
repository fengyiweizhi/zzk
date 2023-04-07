package lanqiao.测评系统;

import java.util.Scanner;

/**
 *
 * 资源限制
 * 内存限制：256.0MB   C/C++时间限制：1.0s   Java时间限制：3.0s   Python时间限制：5.0s
 * 问题描述
 * 　　青蛙X正准备跳过一座桥，这座桥被划分为N段，记青蛙所在的起始点为0，桥的末端为N。桥上的一些点有一些石子，这些点是无法跳上去的。青蛙每次跳跃能向前跳跃+1，+2，+3段，现在请你算出跳到末端的总方法数。如果无法到达，请输出”No Way!"
 * 输入格式
 * 　　输入数据共N行。
 *
 * 　　第一行一个数字N，代表桥的长度。
 *
 * 　　接下来N行，表示从点1~N的道路情况，每行一个数字0或1，1表示有石子。
 * 输出格式
 * 　　输出一行，为一个整数，代表方法数，无法到达为“No Way!"
 * 　　由于数据过大，我们只需要求出 对 1000000007 的余数即可
 * 样例输入
 * 5
 *
 * 1
 *
 * 0
 *
 * 0
 *
 * 1
 *
 * 0
 * 样例输出
 * 3
 * 数据规模和约定
 * 　　N <= 10^6
 *
 * @author 风亦未止
 * @date 2023/4/7 20:35
 */
public class 进击的青蛙 {
    public static void main(String[] args) {
        int mod = (int)1e9 + 7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        nums[0] = 0;
        for(int i = 1 ; i <= n ; i ++) {
            nums[i] = scanner.nextInt();
        }
        //状态表示：f[i] 为，到达i的方案数， f[i] 可以由 i - 1 , i - 2 ,i - 3 到来，
        // f[i] = f[i - 1] + f[i - 2] + f[i - 3]
        int[] f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n ; i++ ) {
            for(int k = 1; k <= 3; k ++) {
                int j = i - k;
                if(j >= 0 && nums[i] != 1 && nums[j] != 1) {
                    f[i] = (f[i] + f[j]) % mod;
                }
            }
        }
        System.out.print(f[n] == 0 ? "No Way!" : f[n]);
    }
}
