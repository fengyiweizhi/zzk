package lanqiao;

/**
 * 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图
 * 中的最短路径。
 * 小蓝的图由2021个结点组成，依次编号1至2021.
 * 对于两个不同的结点a,b,如果a和b的差的绝对值大于21，则两个结点
 * 之间没有边相连;如果a和b的差的绝对值小于等于21，则两个点之间有一条
 * 长度为a和b的最小公倍数的无向边相连。
 * 例如:结点1和结点23之间没有边相连:结点3和结点24之间有一条无
 * 向边，长度为24;结点15和结点25之间有一条无向边，长度为75.
 * 请计算，结点1和结点2021之间的最短路径长度是多少。
 * 提示:建议使用计算机编程解决问题。
 * @author 风亦未止
 */
public class Main14 {
    public static void main(String[] args) {
        int[] f = new int[2050];
        for (int i = 2; i <= 2021; i++) {
            for (int j = i + 1; j <= i + 21; j++) {
                if (f[j] == 0) {
                    f[j] = f[i] + lcm(i, j);
                } else {
                    f[j] = Math.min(f[j], f[i] + lcm(i, j));
                }
            }
        }
        System.out.println(f[2021]);
    }
    private static int lcm(int a, int b) {
        int t = 1;
        while (b * t % a != 0) {
            t++;
        }
        return t * b;
    }
}
