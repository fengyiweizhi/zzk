package acwing;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/9/11 19:28
 */
public class 归并排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=scanner.nextInt();
        }
        merge_sort(num,0,n-1);
        for(int i:num){
            System.out.print(i+" ");
        }
    }
    public static void merge_sort(int[] nums,int l,int r){
        if(l>=r)return;
        //临时数组
        int[] temp=new int[r+1];
        int mid=l+r>>1;
        merge_sort(nums,l,mid);
        merge_sort(nums,mid+1,r);
        int index=0;//临时数组下标
        int i=l; //左边断数组的下标
        int j=mid+1;//右边端数组的下标
        while (i<=mid&&j<=r){
            if(nums[i]<=nums[j]){
                temp[index++]=nums[i++];
            }else{
                temp[index++]=nums[j++];
            }
        }
        //两边不是同时完全放入临时数组里面的，把剩下的放进去
        while (i<=mid)temp[index++]=nums[i++];
        while (j<=r)temp[index++]=nums[j++];
        //把结果放入原数组
        for(i=l,index=0;i<=r;i++,index++){
            nums[i]=temp[index];
        }
    }
}
