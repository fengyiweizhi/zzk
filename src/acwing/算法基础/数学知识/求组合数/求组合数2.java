package acwing.算法基础.数学知识.求组合数;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * 给定 n 组询问，每组询问给定两个整数 a，b，请你输出 Cbamod(109+7) 的值。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一组 a 和 b。
 *
 * 输出格式
 * 共 n 行，每行输出一个询问的解。
 *
 * 数据范围
 * 1≤n≤10000,
 * 1≤b≤a≤105
 * 输入样例：
 * 3
 * 3 1
 * 5 3
 * 2 2
 * 输出样例：
 * 3
 * 10
 * 1
 *
 *
 * 预处理
 * @author 风亦未止
 * @date 2023/2/15 2:46
 */
public class 求组合数2 {
    private static int N = 100010;
    private static long[] nums = new long[N];
    private static long[] infact = new long[N];
    private static int mod = 1000000007;

    // a的k次方模p    求a的模p逆元： a的p-2方模 p
    public static long q_mi(long a, int k , int p){
        long  res = 1;
        while(k > 0){
            //如果k的二进制末尾是1
            if((k & 1) == 1){
                res = (res * a) % p;
            }
            //更新a ，将这次求的模平方再模给下一次(上次模的结果的平方的模)
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }


    private static void init(){
        nums[0] = 1;
        infact[0] = 1;
        for(int i = 1; i < N ;i++){
            nums[i] = (i * nums[i - 1]) % mod;
            infact[i] = (infact[i - 1] * q_mi(i, mod - 2, mod)) % mod;
        }
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0 ){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(nums[a] * infact[b] % mod * infact[a - b] % mod);
        }
    }
}
