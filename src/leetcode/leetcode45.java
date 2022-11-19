package leetcode;

/**
 *跳跃游戏2
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *  从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * @author 风亦未止
 * @date 2022/2/16 14:34
 */
public class leetcode45 {
    public static void main(String[] args) {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
    public static int jump(int[] nums) {
        int length=nums.length;
        if (length==1){
            return 0;
        }
        if (length==2){
            return 1;
        }
        int step=0;
        int reach=0;
        int next=nums[0];
        for(int i=0;i<length;i++){

            next=Math.max(next,i+nums[i]);
            if(next>=length-1){
                return step+1;
            }
            if(i == reach){
                step++;
                reach = next;
            }
        }
        return step;
    }
}
