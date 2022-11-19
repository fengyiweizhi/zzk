package leetcode;

import java.util.*;

/**
 * @author 风亦未止
 * @date 2021/9/17 19:10
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums={1,0,3};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int zeroCount=0;
        Set<Integer> sb=new HashSet<Integer>();
        for(int a=0;a<nums.length;a++){
            sb.add(nums[a]);
            if(nums[a]==0){
                zeroCount++;
                sb.remove(nums[a]);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int b:sb){
            list.add(b);
        }
        for(int i=1;i<=zeroCount;i++){
            list.add(0);
        }
        nums=list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
