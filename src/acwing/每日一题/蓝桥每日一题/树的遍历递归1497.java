package acwing.每日一题.蓝桥每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 一个二叉树，树中每个节点的权值互不相同。
 *
 * 现在给出它的后序遍历和中序遍历，请你输出它的层序遍历。
 *
 * 输入格式
 * 第一行包含整数 N，表示二叉树的节点数。
 *
 * 第二行包含 N 个整数，表示二叉树的后序遍历。
 *
 * 第三行包含 N 个整数，表示二叉树的中序遍历。
 *
 * 输出格式
 * 输出一行 N 个整数，表示二叉树的层序遍历。
 *
 * 数据范围
 * 1≤N≤30,
 * 官方并未给出各节点权值的取值范围，为方便起见，在本网站范围取为 1∼N。
 *
 * 输入样例：
 * 7
 * 2 3 1 5 7 6 4
 * 1 2 3 4 5 6 7
 * 输出样例：
 * 4 1 6 3 5 7 2
 *
 *
 * @author 风亦未止
 * @date 2023/2/20 18:17
 */
public class 树的遍历递归1497 {
    final static int N = 31;

    //后序遍历
    private static int[] a = new int[N];
    //中序遍历
    private static int[] b = new int[N];
    //记录每个数值在中序遍历中的位置
    private static int[] p = new int[N];

    //层序遍历
    private static List<List<Integer>> level = new ArrayList<>();



    private static void build(int al , int ar , int bl , int br, int d) {
        if(ar < al){
            return;
        }
        //后序遍历最后一个是根节点
        int val = a[ar];
        if(level.size() - 1 < d){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(val);
            level.add(arr);
        }else {
            level.get(d).add(val);
        }
        //找出在中序遍历中的下标
        int k = p[val];
         build(al , al + k -1 - bl, bl , k - 1 ,d + 1);

         build( al + k - bl , ar - 1 , k + 1 , br ,d + 1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n ; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 1; i <= n; i ++){
            b[i] = scanner.nextInt();
        }
        //记录每个数值在中序遍历中的位置
        for(int i =  1; i <= n; i++){
            p[b[i]] = i;
        }

        build(1 , n , 1 , n , 0);

        for(List<Integer> list : level){
            for ( int num : list){
                System.out.print(num + " ");
            }
        }

    }


}
