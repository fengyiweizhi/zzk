package lanqiao;

import java.util.Scanner;

/**
 * 如果周一做核酸，周二显示核酸天数为 1 天，周三显示 2 天，以此类推，周六显示 5 天，周日显示 6 天。
 * 　　小蓝在某一天做了一次核酸，请问他的核酸显示为几天。已知做核酸和查看核酸不是在同一天，而且相差不超过 6 天（显示的数为 1 到 6 之间的数）。
 * @author 风亦未止
 * @date 2022/11/6 8:45
 */
public class 模拟赛做核酸 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s =scanner.nextInt();
        int t = scanner.nextInt();
        t=t<s?t+7:t;
        scanner.close();
        System.out.println(t-s);
    }
}
