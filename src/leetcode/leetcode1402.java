package leetcode;

import java.util.Arrays;

/**
 * 一个厨师收集了他n道菜的满意程度satisfaction，这个厨师做出每道菜的时间都是 1 单位时间。
 *
 * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是time[i]*satisfaction[i]。
 *
 * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 *
 * 你可以按任意顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 *
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 *
 * @author 风亦未止
 * @date 2022/2/17 16:24
 */
public class leetcode1402 {
    public static void main(String[] args) {
        int i = maxSatisfaction(new int[]{-1,-8,0,5,-9});
        System.out.println(i);
    }
    public static int maxSatisfaction(int[] satisfaction) {
//        Arrays.sort(satisfaction);
//        int max=0;
//        int index=1;
//        int sum=0;
//        for (int i=0;i<satisfaction.length;i++){
//            for (int j=i;j<satisfaction.length;j++){
//                sum+=index*satisfaction[j];
//                index++;
//            }
//            max=Math.max(max,sum);
//            index=1;
//            sum=0;
//        }
//        return max;
        Arrays.sort(satisfaction);
        int sum = 0,val = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum <= 0) {
                break;
            }
            val += sum;
        }
        return val;
    }

}
