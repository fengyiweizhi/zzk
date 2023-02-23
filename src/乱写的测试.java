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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read = reader.readLine();
        System.out.println(read);
    }
}
