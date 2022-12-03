package acwing.基础算法.位运算;

import java.util.Scanner;

/**
 * 给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。
 * <p>
 * 输入格式
 * 第一行包含整数 n。
 * <p>
 * 第二行包含 n 个整数，表示整个数列。
 * <p>
 * 输出格式
 * 共一行，包含 n 个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中 1 的个数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * 0≤数列中元素的值≤109
 * 输入样例：
 * 5
 * 1 2 3 4 5
 * 输出样例：
 * 1 1 2 1 2
 *
 * @author 风亦未止
 * @date 2022/11/30 22:42
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int index=0;

        //法一
//        while(index<n){
//            int ans=0;
//             for(int i=0;i<32;i++){
//                 ans+=binary(nums[index],i);
//             }
//            index++;
//            System.out.print(ans+" ");
//        }

        //法二,使用lowbit
        for(int i=0;i<n;i++){
            int ans=0;
            while(nums[i]>0){
                nums[i]-=lowbit(nums[i]);
                ans++;
            }
            System.out.println(ans+" ");
        }
    }

    //查看一个数的二进制第n位是1还是0 数字n的二进制第k位是？
    public static int binary(int n,int k){
        //把第k位移到最后一位
        return n>>k&1;
    }

    /**
     * 返回x的最后一位1   x&-x = x&(~x+1)  因为 -x=(~x+1)
     * 原理  x ： 100100
     *      ~x:  011011
     *    ~x+1:  011100
     *    
     * x&(~x+1):   100100 
     *           & 011100 
     *           = 000100  得出结果
     * @param x
     * @return
     */
    public static int lowbit(int x){
        return x&-x;
    }
}
