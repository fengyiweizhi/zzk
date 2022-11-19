package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * [[-1],[2,3],[1,-1,-3]]
 *  -1
 *  2 3
 * 1 1 -3
 * @author 风亦未止
 * @date 2022/2/18 14:52
 */
public class offer100 {
    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(-1);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(-1);
        l2.add(-3);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(1);
        l3.add(8);
        l3.add(3);
        list.add(l);
        list.add(l1);
        list.add(l2);
//        list.add(l3);
        int i = minimumTotal(list);
        System.out.println(i);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
            int length=triangle.size();
            int[][] dp=new int[length][length];
            dp[0][0]=triangle.get(0).get(0);
            for(int i=1;i<length;i++){
                for (int j=0;j<triangle.get(i).size();j++){
                  if (j==0){
                      dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                  } else if (j==triangle.get(i).size()-1){
                      dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                  }else {
                      dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                  }
                }
            }
            Arrays.sort(dp[length-1]);
            return dp[length-1][0];

    }


}
