package lanqiao;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/3/22 18:42
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String[] nums=new String[i];
        for (int j=0;j<i;j++){
            nums[j]=scanner.next();
        }
        String[] res=new String[i];
        for (int j=0;j<i;j++){
            res[j]=Integer.toOctalString(Integer.valueOf(nums[j],16));
            System.out.println(res[j]);
        }
    }
}
