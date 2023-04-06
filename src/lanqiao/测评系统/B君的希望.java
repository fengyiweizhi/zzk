// Created on iPad.

/**
问题描述
　　你有个同学叫B君，他早听闻祖国河山秀丽，列了一张所有可能爬的山的高度表，因“人往高处走”的说法，所以他希望要爬的山按照表上的顺序，并且爬的每一座山都要比前一座高，爬的山数最多，请贵系的你帮他解决这个问题。(cin,cout很坑)
输入格式
　　输入第一行为num(1~1000)和maxHeight(1~8848)，代表山的个数和最大高度
　　输入第二行有num个整数，代表表上每座山的高度height(1~maxHeight)
输出格式
　　输出只有一个数，为符合要求的最大爬山数
样例输入
10 10
8 6 8 5 9 5 2 7 3 6 3 4
样例输出
3
样例输入
10 20
8 19 9 10 3 3 15 3 10 6
样例输出
4
数据规模和约定
　　num(1~1000)，maxHeight(1~8848)，height(1~maxHeight)，都是正整数


 */
import java.util.Scanner;



class B君的希望 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n ; i++  ){
            nums[i] = scanner.nextInt();
        }
        //前i行最长子序列
        int[] f = new int[n];
        int res = 0;
        for(int i = 0; i < n; i ++){
            f[i] = 1;
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]){
                    f[i] = f[j] + 1;
                }
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}