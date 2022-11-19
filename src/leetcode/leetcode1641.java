package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * @author 风亦未止
 * @date 2022/2/16 16:53
 */
public class leetcode1641 {
    public static void main(String[] args) {
        int i = countVowelStrings(3);
        System.out.println(i);
    }
    public static int countVowelStrings(int n) {
        int[] dp={1,1,1,1,1};
        if (n==1){
            return 5;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<5;j++){
                for (int k=j+1;k<5;k++){
                    dp[j]+=dp[k];
                }

            }
        }
        return dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
    }
}
