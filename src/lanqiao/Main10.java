package lanqiao;

import java.util.Scanner;

/**
 * 计挑题
 */
public class Main10 {
   public static int count=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (m!=n) {
            if (m % 2 != 0) {
                m = m + 1;
                count++;
            }
            m=function(m);
        }
        System.out.println(count);
        scanner.close();
    }
    public static int function(int m){
        count++;
        return m/2;
    }
}
