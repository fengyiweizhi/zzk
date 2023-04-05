package acwing.算法基础.动态规划.数位统计DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/340/
 *
 *
 *给定两个整数 a 和 b，求 a 和 b 之间的所有数字中 0∼9 的出现次数。
 *
 * 例如，a=1024，b=1032，则 a 和 b 之间共有 9 个数如下：
 *
 * 1024 1025 1026 1027 1028 1029 1030 1031 1032
 *
 * 其中 0 出现 10 次，1 出现 10 次，2 出现 7 次，3 出现 3 次等等…
 *
 * 输入格式
 * 输入包含多组测试数据。
 *
 * 每组测试数据占一行，包含两个整数 a 和 b。
 *
 * 当读入一行为 0 0 时，表示输入终止，且该行不作处理。
 *
 * 输出格式
 * 每组数据输出一个结果，每个结果占一行。
 *
 * 每个结果包含十个用空格隔开的数字，第一个数字表示 0 出现的次数，第二个数字表示 1 出现的次数，以此类推。
 *
 * 数据范围
 * 0<a,b<100000000
 * 输入样例：
 * 1 10
 * 44 497
 * 346 542
 * 1199 1748
 * 1496 1403
 * 1004 503
 * 1714 190
 * 1317 854
 * 1976 494
 * 1001 1960
 * 0 0
 * 输出样例：
 * 1 2 1 1 1 1 1 1 1 1
 * 85 185 185 185 190 96 96 96 95 93
 * 40 40 40 93 136 82 40 40 40 40
 * 115 666 215 215 214 205 205 154 105 106
 * 16 113 19 20 114 20 20 19 19 16
 * 107 105 100 101 101 197 200 200 200 200
 * 413 1133 503 503 503 502 502 417 402 412
 * 196 512 186 104 87 93 97 97 142 196
 * 398 1375 398 398 405 499 499 495 488 471
 * 294 1256 296 296 296 296 287 286 286 247
 *
 *
 * @author 风亦未止
 * @date 2023/4/3 21:29
 */
public class 计数问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a == 0 && b ==0)break;
            if(a > b) {
                int t = a;
                a = b ;
                b = t;
            }
            //统计每个数字出现的次数
            for(int i = 0; i < 10; i ++){
                //[a , b] 区间内 i 的个数  = [1, b] 区间内1 的个数 - [1, a - 1] 区间内1 的个数
                System.out.print(count(b , i) - count(a - 1, i) + " ");
            }
            System.out.println();
        }
    }

    //计算1 ~ n 中 x的个数
    private static int count(int n, int x) {
        if(n == 0) return 0;
        //把n的每一位弄出来
        List<Integer> num = new ArrayList<>();
        while(n > 0){
            num.add( n % 10);
            n /= 10;
        }
        n = num.size();
        int res = 0;
        //求每一位上 x 的个数  aaabddd , 求 aaa 啥的 * 10的第i位次方 ,如果 x = 0 ，不从最高位开始算，如03324,是前导0
        for(int i = n - 1 - (x == 0 ? 1 : 0); i >= 0; i -- ){
            if(i < n - 1){
                res += get(num, n - 1 , i + 1) * pow10(i);
                //当x == 0时 aaaa0bbbb ,求第i位时减去 10的i次方，因为包括了前导 0的情况 ，减去 0bbb这种情况。
                if(x == 0) res -= pow10(i);
            }
            if(num.get(i) == x){
                res += get(num, i - 1, 0) + 1;
            }else if(num.get(i) > x) {
                res += pow10(i);
            }
        }
        return res;
    }


    //获取第l 位到第 r位 组成的数字
    public static int get(List<Integer> num , int l , int r){
        int res = 0;
        for(int i = l ; i >= r ; i--){
            res = res * 10 +  num.get(i);
        }
        return res;
    }

    //求 10 的i次方
    public static int pow10(int i){
        int res = 1;
        while(i -- > 0){
            res *= 10;
        }
        return res;
    }

}
