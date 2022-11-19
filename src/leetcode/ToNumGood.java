package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 风亦未止
 * @date 2021/9/15 15:56
 */
public class ToNumGood {
    public static void main(String[] args) {
        int length=11;
        int[] nums=new int[length];
        for (int i=0;i<nums.length-1;i++){
            nums[i]=i+1;
        }
        int i = new Random().nextInt(length - 1)+1;
        nums[nums.length-1]=i;
        System.out.println(Arrays.toString(nums));
        System.out.println("==================");
        System.out.println(go(nums));
    }

    public static int go(int[] nums){
        //在知道如1-10的数字的情况下可用异或解法。如果不知道的情况下只能用辅助空间
        int a=0;
        for (int i = 1;i <nums.length ; i++) {
            a=(a^i);
        }
        for (int b = 0; b <nums.length ; b++) {
            a=a^nums[b];
        }
        int[] helper=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //nums的值作为辅助空间的下标,并计数,当nums[i]=nums[x]的值是一样的，则helper的下标一样的进行计数+1，
            helper[nums[i]]++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (helper[nums[j]]==2){
                return nums[j];
            }
        }
        return 0;
    }
}
