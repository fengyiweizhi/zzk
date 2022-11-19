package lanqiao;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long i = scan.nextInt();
        while (i<200000000){
            long result=reverse(i)*i;
            if (100000000<=result&&result<=200000000){
                System.out.println(i);
                return;
            }
            i++;
        }
        System.out.println("F");
    }

    public static long reverse(long x) {
            long rev=0;
            while (x!=0) {
                if (rev<Integer.MIN_VALUE/10||rev>Integer.MAX_VALUE/10) {
                    return 0;
                }
                //回文本
                long digit=x%10;
                x/=10;
                rev=rev*10+digit;
            }
            return rev;
    }

}
