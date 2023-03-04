import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 风亦未止
 * @date 2023/1/4 15:55
 */
public class 乱写的测试 {
    //测试的 差分
//    public static void main(String[] args) {
//        int[] nums = new int[]{1,12,3,4,1,4};
//        int[] c = new int[nums.length + 2];
//        for(int i = 1; i <= nums.length ; i ++){
//            insert(c,i,i,nums[i-1]);
//        }
//
//        for(int i = 1; i <= nums.length ; i ++){
//            System.out.print(c[i] + " ");
//        }
//        System.out.println();
//        int[] pre = new int[nums.length + 2];
//        for(int i = 2; i <= nums.length + 1; i ++ ){
//            pre[i] = pre[i - 1] + c[i - 1];
//            System.out.print(pre[i] + " ");
//        }
//
//    }
//
//    private static void insert(int[] c, int l, int r, int num) {
//        c[l] += num;
//        c[r+1] -= num;
//    }

    //    //测试- 逆元
//    public static void main(String[] args) {
//        int a = 20;
//        int b = 4;
//
//        System.out.println((a / b ) % 3);
//
//        System.out.println( (a * qmi(b, 3 - 2, 3)) % 3);
//    }
//
//
//    private static int qmi(int i , int k , int p ){
//        int res = 1;
//        while(k > 0){
//            if((k & 1) == 1){
//                res = res * i % p;
//            }
//            i = i * i % p;
//            k >>=1;
//        }
//        return res;
//    }
    public static void main(String[] args) throws IOException {
        factorize(90);
    }
    public static void printHollowDiamond(int n) {
        if (n % 2 == 0) {
            // 如果 n 是偶数，则将其加1，使得最中间的行有奇数个星号
            n++;
        }
        // 打印上半部分菱形
        for (int i = 1; i <= n / 2 + 1; i++) {
            for (int j = 1; j <= n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 1; k < 2 * (i - 1); k++) {
                System.out.print(" ");
            }
            if (i != 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 打印下半部分菱形
        for (int i = n / 2; i >= 1; i--) {
            for (int j = 1; j <= n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 1; k < 2 * (i - 1); k++) {
                System.out.print(" ");
            }
            if (i != 1) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void factorize(int n) {
        System.out.print(n + "=");
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i);
                n /= i;
                if (n != 1) {
                    System.out.print("*");
                }
            }
        }
    }
}
