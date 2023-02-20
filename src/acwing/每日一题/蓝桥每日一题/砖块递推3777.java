package acwing.每日一题.蓝桥每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3780/
 * n个砖块排成一排，从左到右编号依次为 1∼n。
 *
 * 每个砖块要么是黑色的，要么是白色的。
 *
 * 现在你可以进行以下操作若干次（可以是 0 次）：
 *
 * 选择两个相邻的砖块，反转它们的颜色。（黑变白，白变黑）
 *
 * 你的目标是通过不超过 3n 次操作，将所有砖块的颜色变得一致。
 *
 * 输入格式
 * 第一行包含整数 T，表示共有 T 组测试数据。
 *
 * 每组数据第一行包含一个整数 n。
 *
 * 第二行包含一个长度为 n 的字符串 s。其中的每个字符都是 W 或 B，如果第 i 个字符是 W，则表示第 i 号砖块是白色的，如果第 i 个字符是 B，则表示第 i 个砖块是黑色的。
 *
 * 输出格式
 * 每组数据，如果无解则输出一行 −1。
 *
 * 否则，首先输出一行 k，表示需要的操作次数。
 *
 * 如果 k>0，则还需再输出一行 k 个整数，p1,p2,…,pk。其中 pi 表示第 i 次操作，选中的砖块为 pi 和 pi+1 号砖块。
 *
 * 如果方案不唯一，则输出任意合理方案即可。
 *
 * 数据范围
 * 1≤T≤10，
 * 2≤n≤200。
 *
 * 输入样例：
 * 4
 * 8
 * BWWWWWWB
 * 4
 * BWBB
 * 5
 * WWWWW
 * 3
 * BWB
 * 输出样例：
 * 3
 * 6 2 4
 * -1
 * 0
 * 2
 * 2 1
 *
 * @author 风亦未止
 * @date 2023/2/17 14:56
 */
public class 砖块递推3777 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while( t -- > 0){
            int n = scanner.nextInt();
            String s = scanner.next();
            char[] cc = s.toCharArray();
            List<Integer> res = new ArrayList<>();
            //变黑色
            for(int i = 0; i < n - 1; i ++){
                if('W' == cc[i]){
                    res.add(i + 1);
                    cc[i] = 'B';
                    if(cc[i + 1] == 'B'){
                        cc[i + 1 ] = 'W';
                    }else {
                        cc[i + 1] = 'B';
                    }
                }
            }
            boolean isb = true;
            for(char c: cc){
                if(c == 'W'){
                    isb = false;
                    break;
                }
            }
            if(isb){
                System.out.println(res.size());
                for(int re : res){
                    System.out.print(re + " ");
                }
                return;
            }

            List<Integer> res2 = new ArrayList<>();
            char[] cc2 = s.toCharArray();
            //变白色
            for(int i = 0; i < n - 1; i ++){
                if('B' == cc2[i]){
                    res2.add(i + 1);
                    cc[i] = 'W';
                    if(cc2[i + 1] == 'B'){
                        cc2[i + 1 ] = 'W';
                    }else {
                        cc2[i + 1] = 'B';
                    }
                }
            }
            boolean isw = true;
            for(char c: cc2){
                if(c == 'B'){
                    isw = false;
                    break;
                }
            }
            if(isw){
                System.out.println(res2.size());
                for(int re : res2){
                    System.out.print(re + " ");
                }
                return;
            }
            System.out.println( -1);
            }



    }
}

