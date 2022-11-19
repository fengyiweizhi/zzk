package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 风亦未止
 * @date 2022/1/12 23:00
 */
public class Main {
    public static void main(String[] args) {
        increasingTriplet(new int[]{20, 100, 10, 12, 5, 13});
    }
    public static boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        ArrayDeque<Object> objects = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=a){
                a=nums[i];
            }else if(nums[i]<=b){
                b=nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
