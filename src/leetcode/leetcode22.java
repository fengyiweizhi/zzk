package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author 风亦未止
 * @date 2022/2/10 21:42
 */
public class leetcode22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        System.out.println(list.toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();

        return list;
    }







    public static List<String> generateParenthesis_error(int n) {
        List<String> list=new ArrayList<>();
        String[][] dp=new String[n][1000];
        dp[0][0]="()";
        for(int i=1;i<n;i++){
            for(int j=0;j<dp[i].length;j++){
                if (dp[i-1][j]!=null&&j==0){
                    dp[i][j]="()"+dp[i-1][j];
                    dp[i][j+1]="("+dp[i-1][j]+")";
                }
                if(dp[i-1][j]!=null&&j!=0){
                    dp[i][j*3-1]="("+dp[i-1][j]+")";
                    dp[i][j*3]="()"+dp[i-1][j];
                    dp[i][j*3+1]=dp[i-1][j]+"()";
                }
            }
        }
        for (int k=0;k<dp[n-1].length;k++){
            if (dp[n-1][k]!=null){
                list.add(dp[n-1][k]);
            }
        }
        return list;
    }
}
