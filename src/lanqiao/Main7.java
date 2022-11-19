package lanqiao;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 成绩分析
 * @author 风亦未止
 * @date 2021/12/23 22:06
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int num = scan.nextInt();
        int good=0;
        int nice=0;
        for (int i=0;i<num;i++){
            int a=scan.nextInt();
            if (a>=85){
                nice++;
                good++;
                continue;
            }
            if (a>=60){
                nice++;
            }
        }
        //格式化
        NumberFormat numberFormat = NumberFormat.getInstance();
        //保留0个小数
        numberFormat.setMaximumFractionDigits(0);
        //优秀率
        System.out.println(numberFormat.format((float)good/(float)num*100)+"%");
        //及格率
        System.out.println(numberFormat.format((float)nice/(float)num*100)+"%");
        scan.close();
    }
}
