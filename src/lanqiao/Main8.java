package lanqiao;

import java.util.Scanner;

/**
 *
 * @author 风亦未止
 * @date 2021/12/23 23:01
 */
public class Main8 {
    public static  int[][] nums;
    public static int result;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
       nums=new int[i][i];
        for (int a=0;a<nums.length;a++){
            for (int b=0;b<nums[a].length;b++){
             nums[a][b]=scan.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(result);
        //在此输入您的代码...
        scan.close();

    }
    public static int dfs(int i,int j){
        if (i<nums.length&&j< nums.length){
            result=Math.max(nums[i][j]+dfs(i+1,j),nums[i][j]+dfs(i+1,j+1));
            return nums[i][j];
        }
        return 0;
    }
}
