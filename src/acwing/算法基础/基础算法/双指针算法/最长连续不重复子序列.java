package acwing.算法基础.基础算法.双指针算法;

import java.util.Scanner;

/**
 *
 * 给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数（均在 0∼105 范围内），表示整数序列。
 *
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。
 *
 * 数据范围
 * 1≤n≤105
 * 输入样例：
 * 5
 * 1 2 2 3 5
 * 输出样例：
 * 3
 * @author 风亦未止
 * @date 2022/11/29 22:44
 */
public class 最长连续不重复子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        //子数组嘛就是
        int[] cheak=new int[100010];
        int ans=0;
        for(int i=0,j=0;i<n;i++){
            cheak[nums[i]]++;
            while(cheak[nums[i]]>1){
                // i 在前面 ，如果遇到相同的了， j 向后移动跟上，
                cheak[nums[j]]--;
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        System.out.println(ans);
    }
}
