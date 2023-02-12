package acwing.算法基础.数学知识.约数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 给定 n 个正整数 ai，请你输出这些数的乘积的约数个数，答案对 109+7 取模。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含一个整数 ai。
 *
 * 输出格式
 * 输出一个整数，表示所给正整数的乘积的约数个数，答案需对 109+7 取模。
 *
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤2×109
 * 输入样例：
 * 3
 * 2
 * 6
 * 8
 * 输出样例：
 * 12
 *
 * @author 风亦未止
 * @date 2023/2/11 15:59
 */
public class 约数个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> map  = new HashMap<>();
        while(n -- > 0){
            int a = scanner.nextInt();
            for(int i = 2 ; i <= a / i; i++){
                while(a % i == 0){
                    a /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            //如果最后没÷尽
            if(a > 1){
                map.put(a ,map.getOrDefault(a, 0) + 1);
            }
        }
        int mod = 1000000007;
        long res = 1;
        for(Integer key : map.keySet()){
            res = res *  (map.get(key) + 1) % mod;
        }
        System.out.println(res);
    }
}
