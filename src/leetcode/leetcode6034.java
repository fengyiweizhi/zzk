package leetcode;

import java.util.ArrayList;

/**
 * @author 风亦未止
 * @date 2022/4/2 22:57
 */
public class leetcode6034 {
    public static void main(String[] args) {
        int i = triangularSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
    public static int triangularSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int n=nums.length;
        while (n!=1){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n-1;i++){
                temp.add((list.get(i)+ list.get(i+1))%10);
            }
            list=temp;
            n=list.size();
        }
        return list.get(0);
    }
}
