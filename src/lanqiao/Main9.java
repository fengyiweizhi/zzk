package lanqiao;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2021/12/26 14:01
 */
public class Main9 {
    public static int[] p;
    public static double[] price;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        p=new int[i];
        price=new double[i];
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMaximumFractionDigits(2);
        for (int a=0;a<i;a++){
            p[a]=scanner.nextInt();
            price[a]= scanner.nextDouble();
        }
        double u=0;
        int sumP=0;
        for (int a=0;a<i;a++){
            u+=p[a]*price[a];
            sumP+=p[a];
        }
        u=u/sumP;
        double newU=Double.parseDouble(instance.format(u));
        double sumAv=0;
        for (int a=0;a<i;a++){
            sumAv+=p[a]*Math.pow(price[a]-newU,2);
        }
        System.out.println(instance.format(Math.sqrt(sumAv/sumP)));
        scanner.close();
    }
}
