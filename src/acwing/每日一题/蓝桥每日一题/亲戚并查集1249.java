package acwing.每日一题.蓝桥每日一题;

import java.io.*;
import java.util.Scanner;

/**
 *
 *
 * 或许你并不知道，你的某个朋友是你的亲戚。
 *
 * 他可能是你的曾祖父的外公的女婿的外甥女的表姐的孙子。
 *
 * 如果能得到完整的家谱，判断两个人是否是亲戚应该是可行的，但如果两个人的最近公共祖先与他们相隔好几代，使得家谱十分庞大，那么检验亲戚关系实非人力所能及。
 *
 * 在这种情况下，最好的帮手就是计算机。
 *
 * 为了将问题简化，你将得到一些亲戚关系的信息，如Marry和Tom是亲戚，Tom和Ben是亲戚，等等。
 *
 * 从这些信息中，你可以推出Marry和Ben是亲戚。
 *
 * 请写一个程序，对于我们的关于亲戚关系的提问，以最快的速度给出答案。
 *
 * 输入格式
 * 输入由两部分组成。
 *
 * 第一部分以 N,M 开始。N 为问题涉及的人的个数。这些人的编号为 1,2,3,…,N。下面有 M 行，每行有两个数 ai,bi，表示已知 ai 和 bi 是亲戚。
 *
 * 第二部分以 Q 开始。以下 Q 行有 Q 个询问，每行为 ci,di，表示询问 ci 和 di 是否为亲戚。
 *
 * 输出格式
 * 对于每个询问 ci,di，输出一行：若 ci 和 di 为亲戚，则输出“Yes”，否则输出“No”。
 *
 * 数据范围
 * 1≤N≤20000,
 * 1≤M≤106,
 * 1≤Q≤106
 * 输入样例：
 * 10 7
 * 2 4
 * 5 7
 * 1 3
 * 8 9
 * 1 2
 * 5 6
 * 2 3
 * 3
 * 3 4
 * 7 10
 * 8 9
 * 输出样例：
 * Yes
 * No
 * Yes
 *
 *
 *
 * @author 风亦未止
 * @date 2023/2/23 16:18
 */
public class 亲戚并查集1249 {
    public static int[] p = new int[20010];

    public static int find(int x) {
        if (p[x] != x) {
            int t = find(p[x]);
            p[x] = t;
        }
        return p[x];
    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = scanner.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for(int i = 1 ; i <= n ; i++){
            p[i] = i;
        }
        while(m -- > 0){
            String[] ss = scanner.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            if(find(a) != find(b)){
                p[find(a)] = p[find(b)];
            }
        }
        int q = Integer.parseInt(scanner.readLine());
        while(q-- > 0){
            String[] ss = scanner.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            bw.write(find(a) == find(b) ? "Yes\n" : "No\n");
        }
        bw.flush();
        bw.close();
    }
}
