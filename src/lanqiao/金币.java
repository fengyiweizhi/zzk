package lanqiao;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/11/5 21:55
 */
public class 金币 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day=scan.nextInt();
        //在此输入您的代码...
        scan.close();
//        f(1);
        int temp=0;
        int sum=0;
        while(day>0){
            int index=1;
            temp++;
            while(index<=temp&&day>0){
                sum+=temp;
                index++;
                day--;
            }
        }
        System.out.println(sum);
    }

}
