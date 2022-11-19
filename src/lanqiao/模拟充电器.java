package lanqiao;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 小蓝有一个充电器，可以使用不同的电压和电流充电。
 * 　　给定充电器工作的记录，请计算在这个记录期间总共通过充电传输了多少电能。
 * 输入格式
 * 　　输入第一行包含一个整数 n ， 表示记录的条数。
 * 　　接下来 n 行，每行包含一个时刻 T 和两个非负整数 U, I，表示在时刻 T 充电电压变为 U（单位伏），电流变为 I（单位A）。最后一行满足 U 和 I 均为 0，在前面的行中也可能出现 U、I 为 0 的情况。其中时间表示为 HH:MM:SS 的格式，时分秒分别用两位十进制数表示（补前导零）。
 * 　　输入保证时刻依次递增且在 00:00:00 至 23:59:59 的区间内，不用考虑跨过零点充电的情况。
 * 输出格式
 * 　　输出一个整数，表示总共通电的电能为多少焦耳，其中 1 焦耳等于 1 伏乘以1 安乘以 1 秒。
 * 样例输入
 * 3
 * 12:00:00 12 1
 * 12:01:02 5 2
 * 12:01:10 0 0
 * 样例输出
 * 824
 * 评测用例规模与约定
 * 　　对于所有评测用例，1 <= n <= 100， 0 <= U, I <= 100。
 * JAVA
 * 138
 *91380
 * @author 风亦未止
 * @date 2022/11/6 9:01
 */
public class 模拟充电器 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String[] str=new String[n];
        for (int i=0;i<n;i++){
            str[i]=scanner.nextLine();
        }
        scanner.close();
        String[] time=new String[n];
        int[] timeL=new int[n];
        int[] u=new int[n];
        int[] I=new int[n];
        for (int i=0;i<n;i++){
            String[] s = str[i].split(" ");
            time[i]=s[0];
            u[i]=Integer.parseInt(s[1]);
            I[i]=Integer.parseInt(s[2]);
        }
        for (int i=0;i<n;i++){
            String[] split = time[i].split(":");
            timeL[i]=(Integer.parseInt(split[0])*60+Integer.parseInt(split[1]))*60+Integer.parseInt(split[2]);
        }
        int ans=0;
        for(int i=1;i<n;i++){
            int s= timeL[i]-timeL[i-1];
            ans+= s*u[i-1]*I[i-1];
        }
        System.out.println(ans);
    }


}
