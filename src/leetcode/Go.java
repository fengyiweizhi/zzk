package leetcode;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2021/11/18 17:07
 */
public class Go {
    public static void main(String[] args) {
        int first=1;
        int count=0;
        int sum=0;
        int max=0;
        int min=0;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            if(first==1){
                count=scan.nextInt();
                first=2;
                continue;
            }
            if(first==2){
                min=scan.nextInt();
            }
            sum=sum+scan.nextInt();
            max=Math.max(max,scan.nextInt());
            min=Math.min(min,scan.nextInt());
        }
        double av=sum/count;
        System.out.println(max);
        System.out.println(min);
        System.out.println(av);
        //在此输入您的代码...
        scan.close();
    }
}
