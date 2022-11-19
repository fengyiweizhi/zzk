package leetcode;


import java.util.Arrays;

/**
 * @author 风亦未止
 * @date 2021/9/23 21:14
 */
public class ThreeBig {
    public static void main(String[] args) {
        int[] nums={1,4,2,3};
        Arrays.sort(nums);
        int i = thirdMax(nums);
        System.out.println(i);
    }
    public static int thirdMax(int[] nums){
        Arrays.sort(nums);
        if (nums.length==2){
            return nums[1];
        }
        if (nums.length==1){
            return nums[0];
        }
        int thirdMaxIndex=1;
        int index1=nums.length-1;
        int index2=nums.length-2;
        while (index1>=0&&index2>=0){
            if (nums[index2]<nums[index1]){
                thirdMaxIndex++;
                if (thirdMaxIndex==3){
                    return nums[index2];
                }
            }
            index1--;
            index2--;
        }
        return 0;
    }
}
