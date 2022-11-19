package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  二叉搜索树染色
 * @author 风亦未止
 * @date 2022/4/16 17:15
 */
public class leetcode_1 {


   public class TreeNode {
      int val;
       TreeNode left;
      TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public Set<Integer> res=new HashSet<>();
        public int getNumber(TreeNode root, int[][] ops) {
            for(int[] o:ops){
                dfs(root,o[0],o[1],o[2]);
            }
            return res.size();
        }

        public void dfs(TreeNode root,int color,int i,int j){
            if(root==null){
                return;
            }
            dfs(root.left,color,i,j);
            if(color==1&&root.val>=i&&root.val<=j){
                res.add(root.val);
            }
            if(color==0&&root.val>=i&&root.val<=j){
                List<Integer> temp=new ArrayList<>(res);
                for(int in=0;in<temp.size();in++){
                    if(temp.get(in)==root.val){
                        temp.remove(in);
                        break;
                    }
                }
                res=new HashSet<>(temp);
            }
            dfs(root.right,color,i,j);
        }



    }
}
