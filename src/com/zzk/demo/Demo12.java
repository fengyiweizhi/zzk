package com.zzk.demo;

/**
 * 二分查找
 * @author 风亦未止
 */
public class Demo12 {
    public static void main(String[] args) {
        int[] a={10,20,30,40,50,60,70,80,90,100};
        int front=0;
        int end=a.length-1;
        int mid=(front+end)/2;
        int num=101;
        while (true){
            if (num>a[mid]){
                front=mid+1;
                mid=(front+end)/2;
            }
            else if (num<a[mid]){
                end=mid-1;
                mid=(front+end)/2;
            }
            if (end<front){
                System.out.println("不存在");
                break;
            }
            if (num==a[mid]){
                System.out.println("查找的数字在"+mid+"位置");
                break;
            }
        }
    }
}
