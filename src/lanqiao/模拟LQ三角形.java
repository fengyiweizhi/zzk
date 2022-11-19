package lanqiao;

import java.util.Scanner;

/**
 * 给定一个字母矩阵，定义一个LQ三角形为某行中连续的几个字母、某列中连续的几个字母和一条45度的斜线中连续的几个字母组成的等腰直角三角形的边缘部分，其中每条边上的字母数量相等且至少为2 。
 * 　　例如，对于下面的字母矩阵中，所有的字母 L 组成一个LQ三角形，所有字母 Q 组成了一个 LQ 三角形，所有字母 C 也组成了一个 LQ 三角形。
 * 　　AAAAAAA
 * 　　ALLLLLA
 * 　　ALQQLAA
 * 　　ALQLAAC
 * 　　ALLAACC
 * 　　ALAACCC
 * 　　如果一个 LQ 三角形边上的所有字母相等，则称为一个全相等三角形。以三个例子都是全相等三角形。
 * 　　给定一个字母矩阵，请求其中有多少个全相等三角形。
 * 输入格式
 * 　　输入第一行包含两个整数 n, m，分别表示字母矩阵的行数和列数。
 * 　　接下来 n 行，每行 m 个大写字母，为给定的矩阵。
 * 输出格式
 * 　　输出一行，包含一个整数，表示答案。
 *
 * @author 风亦未止
 * @date 2022/11/6 9:49
 */
public class 模拟LQ三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int m =scanner.nextInt();
        String[][] w=new String[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                w[n][m]=scanner.next();
            }
        }

        scanner.close();
    }
}
