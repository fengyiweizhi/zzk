package lanqiao;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2021/12/26 15:29
 */
public class Main12 {
    public static Long[] number;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        number=new Long[l];
        for (int a=0;a<l;a++){
            number[a]=scanner.nextLong();
        }
        int count=0;
        for (int a=0;a<l-1;a++){
            for (int b=a+1;b<l;b++){
                if (number[a]<number[b]){
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
