package meituan;

import java.util.Scanner;

/**
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * A国有n个城市，这n个城市排成一列，依次编号为1,2,3,...,n。一开始，这n座城市之间都没有任何交通路线，于是政府打算修建一些铁路来进行交通规划。
 * 接下来T天，每一天会进行如下操作的其中一种：
 *
 * - “L x”：表示编号为 x 的城市与其左边的城市之间修建一条铁路。如果 x 左边没有城市或者已经修建了铁路，则无视该操作；
 *
 * - “R x”：表示编号为 x 的城市与其右边的城市之间修建一条铁路。如果 x 右边没有城市或者已经修建了铁路，则无视该操作；
 *
 * - “Q x”：表示查询 x 往左边和往右边最远能到达的城市编号。
 *
 * 你的任务是模拟以上操作，并对于每一条“Q x”操作，输出对应的答案。
 *
 *
 *
 * 输入描述
 * 第一行输入两个正整数 n , T ；
 *
 * 接下来T行，每行输入形如题面中的其中一种。
 *
 * 1≤n≤10000,  1≤T≤200， 1≤x≤n
 *
 * 输出描述
 * 对于每一个"Q x”操作，输出一行两个正整数，分别表示 x 往左边和往右边最远能到达的城市编号，中间用空格隔开。
 * 1-2 3
 *
 * 样例输入
 * 3 5
 * Q 2
 * L 2
 * Q 2
 * R 2
 * Q 2
 * 样例输出
 * 2 2
 * 1 2
 * 1 3
 *
 * 提示
 * “Q 2”：一开始城市2没有与左边和右边联通，故最左和最右都是城市2；
 *
 * “L 2”：城市2与城市1联通；
 *
 * “Q 2”：此时最左能够到达城市1，最右能到达城市2；
 *
 * “R 2”：城市2与城市3联通：
 *
 * “Q 2”：此时最左能够到达城市1，最右能到达城市3；
 *
 *
 * @author 风亦未止
 * @date 2023/4/15 10:48
 */
public class 交通规划 {

    private static int[] r = new int[10005];
    private static int[] l = new int[10005];
    private static int n;

    private static int ql(int x){
        if(l[x] != x){
            l[x] = ql(l[x]);
        }
        return l[x];
    }
    private static int qr(int x){
        if(r[x] != x){
            r[x] = qr(r[x]);
        }
        return r[x];
    }


    private static void init() {
        for(int i = 1; i <= n; i ++){
            r[i] = i;
        }
        for(int i = 1; i <= n; i ++){
            l[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        init();
        int t = scanner.nextInt();
        while(t -- > 0){
            String op = scanner.next();
            int x = scanner.nextInt();
            if(op.equals("Q")){
                int ll = ql(x);
                int rr = qr(x);
                System.out.println(ll + " " + rr);
            }
            if(op.equals("L")){
                if(ql(x) == x && x - 1 != 0 && qr(x - 1) == x - 1){
                    l[x] = x - 1;
                    r[x - 1] = x;
                }
            }
            if(op.equals("R")){
                if(qr(x) == x && x + 1 <= n && ql(x + 1) == x + 1){
                    r[x] = x + 1;
                    l[x + 1] = x;
                }
            }
        }

    }
}
