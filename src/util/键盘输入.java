package util;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/11/5 21:18
 */
public class 键盘输入 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scan.nextInt();
        }
        scan.close();
    }
}
