package meituan;

import java.util.Scanner;

/**字符串前缀
 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 现在有两个字符串S和T，你需要对S进行若干次操作，使得S是T的一个前缀（空串也是一个前缀）。每次操作可以修改S的一个字符，或者删除一个S末尾的字符。

 小团需要写一段程序，输出最少需要操作的次数。



 输入描述
 第一行一个正整数C，表示数据组数；

 对于每一组数据输入两行仅包含小写字母的字符串S和T。

 1≤|S|,|T|≤5X104  , 1≤C≤10

 输出描述
 对于每一组数据，输出一个整数，表示最少需要操作的次数。


 样例输入
 2
 aba
 abb
 abcd
 efg
 样例输出
 1
 4

 提示
 第一组数据，可以修改最后一个字母，使得S=abb，是T的一个前缀；第二组数据，需要将S整个串删除，操作次数为4。
 * @author 风亦未止
 * @date 2023/4/15 10:35
 */
public class 字符串前缀 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n -- > 0){
            String s = scanner.next();
            String t = scanner.next();
            int slen = s.length();
            int tlen = t.length();
            int sidx = 0;
            int res = 0;
            for(int i = 0 ;i < tlen; i ++){
                while(sidx < slen){
                    if(t.charAt(i) != s.charAt(sidx)){
                        res++;
                        sidx++;
                    }else{
                        sidx++;
                        break;
                    }
                }
            }
            res += slen - sidx;
            System.out.println(res);
        }
    }
}
