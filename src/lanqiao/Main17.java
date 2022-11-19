package lanqiao;

import java.util.Scanner;

/**
 *子串分值
 *
 *对于一个字符串 SS，我们定义 SS 的分值 f(S)f(S) 为 SS 中恰好出现一次的字符个数。例如 f(aba) = 1，f(abc) = 3, f(aaa) = 0f(aba)=1，f(abc)=3,f(aaa)=0。
 *
 *现在给定一个字符串 S_{0 \cdots n − 1}S
 * 0⋯n−1
 *（长度为 nn，1 \leq n \leq 10^51≤n≤10
 * 5
 *  ），请你计算对于所有 SS 的非空子串 S_{i \cdots j}(0 ≤ i ≤ j < n)S
 * i⋯j
 *  (0≤i≤j<n)，f(S_{i \cdots j})f(S
 * i⋯j
 *  ) 的和是多少。
 * 输入
 * ababc
 * 输出
 * 21
 *
 * a       1 1 1 1 1
 * a?      1 2 2 2 2
 * a??     1 2 1 2 1
 * a???    1 2 1 0 0
 * a????   1 2 1 1 1
 *  b        1 1 1 1
 *  b?       1 2 2 2
 *  b??      1 2 1 1
 *  b???     1 2 1 2
 *   a         1 1 1
 *   a?        1 2 2
 *   a??       1 2 3
 *    b          1 1
 *    b?         1 2
 *     c           1
 *
 *
 * a       1
 * ab      2
 * aba     1
 * abab    0
 * ababc   1
 *  b      1
 *  ba     2
 *  bab    1
 *  babc   2
 *   a     1
 *   ab    2
 *   abc   3
 *    b    1
 *    bc   2
 *     c   1
 *
 * a(5+4-3-2+1)b(4+3-2+1)a(3+2+1)b(2+1)c(1)
 * a(5)b(6)a(6)b(3)c(1)
 * @author 风亦未止
 * @date 2022/2/13 14:36
 *
 * 子串分值和
 *
 * a       1   a
 * ab      2   a b
 * aba     2   a b
 * abab    2   a b
 * ababc   3   a b          c
 *  b      1     b
 *  ba     2     b  a
 *  bab    2     b  a
 *  babc   3     b  a       c
 *   a     1        a
 *   ab    2        a   b
 *   abc   3        a   b   c
 *    b    1            b
 *    bc   2            b   c
 *     c   1                c
 *
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        int length = s.length();
        int[] loc=new int[26];
        for (int i=0;i<26;i++){
            loc[i]=-1;
        }
        int result=0;
        for(int i=0;i<s.length();i++,length--){
            result+=(i-loc[s.charAt(i)-'a'])*length;
            loc[s.charAt(i)-'a']=i;
        }
        System.out.println(result);
    }

}
