package com.zzk.demo;

/**
 * 选队长
 * @author 风亦未止
 */
public class Demo13 {
    public static void main(String[] args) {
        String[] s={"同学1","同学2","同学3"};
        //人数
        int p=s.length;
        //报的数字
        int num=1;
        //下标
        int n=0;
        while (p!=1){
            //数到3的同学变为空
            for (int a=1;a<p+1;a++){
                if (num==4){
                    //重置报的数
                    num=1;
                }
                if (num%3==0){
                    s[a-1]=null;
                }
                num++;
            }
            //计算不为null的数量
            for (int a=1;a<=s.length;a++){
                if (s[a-1]!=null){
                    n++;
                }
            }
            //储存n的值
            p=n;
            //重置n得值
            n=0;
            //将null放在后面
            for(int a=1;a<=s.length-1;a++){
                for (int b=0;b<=s.length-1-a;b++){
                    if (s[b]==null){
                        s[b]=s[b+1];
                        s[b+1]=null;
                    }
                }

            }

        }
        System.out.println(s[0]+"为队长");

    }
}
