package leetcode;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @author 风亦未止
 * @date 2022/2/21 17:51
 */
public class leetcode77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine.toString());
    }
    public static Deque<Integer> path=new LinkedList<>();
    public static List<List<Integer>> result=new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return result;
    }

    public static void backtrack(int n,int k,int index){
            if (path.size()==k){
                result.add(new LinkedList<>(path));
                return;
            }
            for (int i=index;i<=n;i++){
                path.add(i);
                backtrack(n,k,i+1);
                path.pop();
            }
    }


}
