package lanqiao;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/3/29 22:51
 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]= scanner.nextInt();
        }
        int[] dp=new int[V+1];
        for(int i=0;i<n;i++){
            for(int j=V;j>=a[i];j--){
                dp[j]=Math.max(dp[j],dp[j-a[i]]+1);
            }
        }
        System.out.println(dp[V]);
    }

}
//
//1
//1 2
//1 3 7
//6 9 4 2
//6 4 2 1 3
//
//f[i][j]+=min(f[i+1][j+1],f[i+1][j])