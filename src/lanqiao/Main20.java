package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/3/22 18:38
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] nums=new int[i];
        for (int j=0;j<i;j++){
            nums[j]= scanner.nextInt();
        }
        Arrays.sort(nums);
        for (int j=0;j<i;j++){
            System.out.print(nums[j]+" ");
        }
    }
}
