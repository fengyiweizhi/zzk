package 杂题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 风亦未止
 * @date 2023/4/7 22:20
 */
public class  某些算法的方法{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int r : get_prime(1000000)){
            System.out.println(r);
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("用时%s毫秒",end - start));
    }
    //将某进制转换为10进制
    private static int convert(String s, int original ){
        int res = 0;
        char[] cc = s.toCharArray();
        for(char c : cc){
            res = res * original + c - '0';
        }
        return res;
    }

    //辗转反侧法求最大公约数
    public static int gcd(int a , int b){
        return b == 0 ? a :  gcd(b, a % b);
    }

    //快速幂 a 的 b 次方
    public  static  int q_min(int a , int b){
        int res = 1;
        while(b > 0){
            if((b & 1) == 1){
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }

    //筛质数，求0 ~ n的质数
    public static List<Integer> get_prime(int  n){
        List<Integer> res = new ArrayList<>();
        boolean[] std = new boolean[n];
        for(int i = 2; i < n  ; i++){
            if(!std[i]){
                res.add(i);
                std[i] = true;
                for(int j = i + i ; j < n ; j += i){
                    std[j] = true;
                }
            }
        }
        return res;
    }


}
