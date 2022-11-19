package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 风亦未止
 * @date 2022/1/30 20:21
 *
 * // 方式一：不要想那么多，纯递归思想！如果你想着怎么构建左子树右子树，就变的无从下手了！
 *     // 树类题目，不好思考就想着纯递归
 *     // 递归的时候不要想如果解子问题以及子子问题以及子子子... 问题，
 *     // 你就想着当前的这个树的节点，我要解决的话，就得拿到左子树和右子树的所有情况，
 *     // 然后根据两边的集合拼凑当前节点的结果就好了！然后加上递归的终止条件，就行了！
 *     // 递归就是这么简单！树天生就是可以拆分成子问题的题目！天生就可以用递归来做！
 *     // 好好再领悟一下递归思想！！
 *
 * 作者：tuo-jiang-de-ye-ma-2
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/cu-su-yi-dong-chun-di-gui-gen-zhao-di-gu-7zok/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Demo894 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = allPossibleFBT(11);
        System.out.println(treeNodes);
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list=new ArrayList<>();
        if(n==1){
            TreeNode t= new TreeNode(0);
            list.add(t);
            return list;
        }
        if(n%2==0){
            return list;
        }
        for(int i=1;i<n;i+=2){
            List<TreeNode> Llist= allPossibleFBT(i);
            List<TreeNode> Rlist=allPossibleFBT(n-i-1);
            for(TreeNode L:Llist){
                for(TreeNode R:Rlist){
                    TreeNode root=new TreeNode(0);
                    root.left=L;
                    root.right=R;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
