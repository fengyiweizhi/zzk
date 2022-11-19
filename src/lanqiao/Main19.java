package lanqiao;

/**
 * 高精度
 */

import java.util.Scanner;
public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        int[] anums = new int[100];
        int length = a.length();
        for(int i=0;i<length;i++){
            int index=length-i-1;
            anums[i]=a.charAt(index)-'0';
        }
        String b = scanner.next();
        int[] bnums = new int[100];
        int blength = b.length();
        for(int i=0;i<blength;i++){
            int index=blength-i-1;
            bnums[i]=b.charAt(index)-'0';
        }
        int[] res=new int[100];
        int c=0;
        for (int i=0;i<anums.length;i++){
            int s=bnums[i]+anums[i]+c;
            res[i]=s%10;
            c=s/10;
        }
        for (int i=anums.length-1;i>=0;i--){
            if (res[i]!=0){
                for (int j=i;j>=0;j--){
                    System.out.print(res[j]);
                }
                break;
            }
        }

    }
}
