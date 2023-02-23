package acwing.每日一题.蓝桥每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2060/
 *奶牛贝茜正在学习如何在不同进制之间转换数字。
 *
 * 但是她总是犯错误，因为她无法轻易的用两个前蹄握住笔。
 *
 * 每当贝茜将数字转换为一个新的进制并写下结果时，她总是将其中的某一位数字写错。
 *
 * 例如，如果她将数字 14 转换为二进制数，那么正确的结果应为 1110，但她可能会写下 0110 或 1111。
 *
 * 贝茜不会额外添加或删除数字，但是可能会由于写错数字的原因，写下包含前导 0 的数字。
 *
 * 给定贝茜将数字 N 转换为二进制数字以及三进制数字的结果，请确定 N 的正确初始值（十进制表示）。
 *
 * 输入格式
 * 第一行包含 N 的二进制表示，其中一位是错误的。
 *
 * 第二行包含 N 的三进制表示，其中一位是错误的。
 *
 * 输出格式
 * 输出正确的 N 的值。
 *
 * 数据范围
 * 0≤N≤109，且存在唯一解。
 *
 * 输入样例：
 * 1010
 * 212
 * 输出样例：
 * 14
 * 样例解释
 * 14 在二进制下的正确表示为 1110，在三进制下的正确表示为 112。
 *
 * @author 风亦未止
 * @date 2023/2/23 17:03
 */
public class 笨拙的手指哈希2058 {


    //将某进制转换为10进制
    private static int convert(String s, int original ){
        int res = 0;
        char[] cc = s.toCharArray();
        for(char c: cc){
            res = res * original + c - '0';
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < a.length(); i++){
            char[] ss = a.toCharArray();
            ss[i] ^= 1;
            map.add(convert(String.valueOf(ss), 2));
        }
        for(int i = 0 ; i <= b.length(); i++){
            char[] ss = b.toCharArray();
            for(int j = 1; j < 3; j ++){
                if(ss[i] <= '1' ){
                    ss[i] ++;
                }else if(ss[i] == '2'){
                    ss[i] = '0';
                }
                int res = convert(String.valueOf(ss), 3);
                if(map.contains(res)){
                    System.out.println(res);
                    return;
                }
            }
        }
    }

}
