package acwing.每日一题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4513/
 *
 *
 * 暑假要到了。
 *
 * 可惜由于种种原因，小 P 原本的出游计划取消。
 *
 * 失望的小 P 只能留在西西艾弗岛上度过一个略显单调的假期……直到……
 *
 * 某天，小 P 获得了一张神秘的藏宝图。
 *
 * 西西艾弗岛上种有 n 棵树，这些树的具体位置记录在一张绿化图上。
 *
 * 简单地说，西西艾弗岛绿化图可以视作一个大小为 (L+1)×(L+1) 的 01 矩阵 A，地图左下角（坐标 (0,0)）和右上角（坐标 (L,L)）分别对应 A[0][0] 和 A[L][L]。
 *
 * 其中 A[i][j]=1 表示坐标 (i,j) 处种有一棵树，A[i][j]=0 则表示坐标 (i,j) 处没有树。
 *
 * 换言之，矩阵 A 中有且仅有的 n 个 1 展示了西西艾弗岛上 n 棵树的具体位置。
 *
 * 传说，大冒险家顿顿的宝藏就埋藏在某棵树下。
 *
 * 并且，顿顿还从西西艾弗岛的绿化图上剪下了一小块，制作成藏宝图指示其位置。
 *
 * 具体来说，藏宝图可以看作一个大小为 (S+1)×(S+1) 的 01 矩阵 B（S 远小于 L），对应着 A 中的某一部分。
 *
 * 理论上，绿化图 A 中存在着一处坐标 (x,y)（0≤x,y≤L−S）与藏宝图 B 左下角 (0,0) 相对应，即满足：
 *
 * 对 B 上任意一处坐标 (i,j)（0≤i,j≤S），都有 A[x+i][y+j]=B[i][j]。
 *
 * 当上述条件满足时，我们就认为藏宝图 B 对应着绿化图 A 中左下角为 (x,y)、右上角为 (x+S,y+S) 的区域。
 *
 * 实际上，考虑到藏宝图仅描绘了很小的一个范围，满足上述条件的坐标 (x,y) 很可能存在多个。
 *
 * 请结合西西艾弗岛绿化图中 n 棵树的位置，以及小 P 手中的藏宝图，判断绿化图中有多少处坐标满足条件。
 *
 * 特别地，藏宝图左下角位置一定是一棵树，即 A[x][y]=B[0][0]=1，表示了宝藏埋藏的位置。
 *
 * 输入格式
 * 输入的第一行包含空格分隔的三个正整数 n、L 和 S，分别表示西西艾弗岛上树的棵数、绿化图和藏宝图的大小。
 *
 * 由于绿化图尺寸过大，输入数据中仅包含 n 棵树的坐标而非完整的地图；即接下来 n 行每行包含空格分隔的两个整数 x 和 y，表示一棵树的坐标，满足 0≤x,y≤L 且同一坐标不会重复出现。
 *
 * 最后 (S+1) 行输入小 P 手中完整的藏宝图，其中第 i 行（0≤i≤S）包含空格分隔的 (S+1) 个 0 和 1，表示 B[S−i][0]⋯B[S−i][S]。
 *
 * 需要注意，最先输入的是 B[S][0]⋯B[S][S] 一行，B[0][0]⋯B[0][S] 一行最后输入。
 *
 * 输出格式
 * 输出一个整数，表示绿化图中有多少处坐标可以与藏宝图左下角对应，即可能埋藏着顿顿的宝藏。
 *
 * 数据范围
 * 40% 的测试数据满足：L≤50；
 * 70% 的测试数据满足：L≤2000；
 * 全部的测试数据满足：n≤1000、L≤109 且 S≤50。
 *
 * 输入样例1：
 * 5 100 2
 * 0 0
 * 1 1
 * 2 2
 * 3 3
 * 4 4
 * 0 0 1
 * 0 1 0
 * 1 0 0
 * 输出样例1：
 * 3
 * 样例1解释
 * 绿化图上 (0,0)、(1,1) 和 (2,2) 三处均可能埋有宝藏。
 *
 * 输入样例2：
 * 5 4 2
 * 0 0
 * 1 1
 * 2 2
 * 3 3
 * 4 4
 * 0 0 0
 * 0 1 0
 * 1 0 0
 * 输出样例2：
 * 0
 * 样例2解释
 * 如果将藏宝图左下角与绿化图 (3,3) 处对应，则藏宝图右上角会超出绿化图边界，对应不成功。
 *
 * @author 风亦未止
 * @date 2023/1/17 21:48
 */
public class 寻宝大冒险4510 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int s = scanner.nextInt();
        //记录树的坐标
        int[][] tree = new int[n][2];

        HashSet<String> set = new HashSet<>();
        for (int i = 0 ; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            tree[i] = new int[]{x, y};
            set.add(x + "-" + y);
        }
        int[][] S = new int[s + 1][s + 1];
        for(int i = s; i >= 0; i--){
            for(int j = 0; j <= s; j++){
                S[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        for(int[] w : tree){
            int x = w[0], y = w[1];
            if(x + s > l || y + s > l){
                continue;
            }
            boolean flag = true;
            for (int i = 0; i <= s; i ++) {
                for (int j = 0; j <= s; j ++){
                    int a = x + i;
                    int b = y + j;
                    String ff = a + "-" + b;
                    if ( S[i ][j] == 0 && set.contains(ff) || S[i ][j] == 1 && !set.contains(ff)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if(flag){
                res ++;
            }
        }
        System.out.println(res);
    }
}
