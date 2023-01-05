package acwing.算法基础.数据结构.Trie;

import java.util.Scanner;

/**
 *  https://www.acwing.com/video/63/
 * 异或
 * 1001
 * ^1111
 * =0110
 * <p>
 * 在给定的 N 个整数 A1，A2……AN 中选出两个进行 xor（异或）运算，得到的结果最大是多少？
 * <p>
 * 输入格式
 * 第一行输入一个整数 N。
 * <p>
 * 第二行输入 N 个整数 A1～AN。
 * <p>
 * 输出格式
 * 输出一个整数表示答案。
 * <p>
 * 数据范围
 * 1≤N≤105,
 * 0≤Ai<231
 * 输入样例：
 * 3
 * 1 2 3
 * 输出样例：
 * 3
 *
 * @author 风亦未止
 * @date 2022/12/30 22:59
 */
public class 最大异或对 {
    public static int[][] son = new int[3000000][2];  //32 * 10^5
    public static int idx = 0;

    public static void insert(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int s = x >> i & 1;
            if (son[p][s] == 0) {
                son[p][s] = ++idx;
            }
            p = son[p][s];
        }
    }

    public static int query(int x) {
        int p = 0;
        int res = 0;
        for (int i = 31; i >= 0;i-- ) {
            int s = (x>>i&1)==1?0:1;
            if(son[p][s]!=0){
                res += 1<<i;
                p = son[p][s];
            }else{
                p = son[p][s==1?0:1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
            insert(nums[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res,query(nums[i]));
        }
        System.out.println(res);

    }
}
