package leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * @author 风亦未止
 * @date 2022/2/12 13:55
 */
public class leetcode64 {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int i = minPathSum2(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(i);
    }

    public static int minPathSum2(int[][] grid) {
        int row= grid.length;
        int col=grid[row-1].length;
        int[][] dp=new int[row][col];
        //初始化
        dp[0][0]=grid[0][0];
        for(int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int j=1;j<row;j++){
            dp[j][0]=dp[j-1][0]+grid[j][0];
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static int minPathSum(int[][] grid) {
        dfs(grid,0,0);
        return min+grid[0][0];
    }

    public static int dfs(int[][] grid,int i,int j){
//        if (i==grid.length-1&&j==grid[0].length-1){
//            return grid[i][j];
//        }
//        if (i<grid.length&&j<grid[0].length){
//            min=Math.min(min,dfs(grid,i+1,j));
//            min=Math.min(min,dfs(grid,i,j+1));
//            return min+grid[i][j];
//        }
//        return min;


        if (i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        int[][] a={{0,1},{1,0}};
        for (int k=0;k<a.length;k++){
            if (i+a[k][0]>=grid.length||j+a[k][1]>=grid[0].length){
                continue;
            }
            min=Math.min(min,dfs(grid,i+a[k][0],j+a[k][1]));
        }
        return min+grid[i][j];
    }
}
