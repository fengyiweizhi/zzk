package com.zzk.demo;

/**
 * 冒泡排序
 * @author 风亦未止
 */
public class Demo11 {
    public static void main(String[] args) {
        int[] a={10,22,15,54,34,64,12,3,5};
        int j;
        //轮数：数组长度-1轮
        for (int i=1;i<=a.length-1;i++){
            //次数
            for (int b=0;b<=a.length-1-i;b++){
                if (a[b]>a[b+1]) {
                    j=a[b];
                    a[b]=a[b+1];
                    a[b+1]=j;
                }
            }
        }
        for (int c=0;c<a.length;c++){
            System.out.print(a[c]+"\t");
        }
    }
}
