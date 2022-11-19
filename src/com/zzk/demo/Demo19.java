package com.zzk.demo;

import java.util.Random;
import java.util.Scanner;

/**
 * 双色球
 * @author 风亦未止
 */
public class Demo19 {
    public static void main(String[] args) {
        int[] red=new int[6];
        int[] buy=new int[6];
        int buy2;
        int yes=0;
        int blue=new Random().nextInt(15)+1;
        red[0]=new Random().nextInt(33)+1;
        red[1]=new Random().nextInt(33)+1;
        red[2]=new Random().nextInt(33)+1;
        red[3]=new Random().nextInt(33)+1;
        red[4]=new Random().nextInt(33)+1;
        red[5]=new Random().nextInt(33)+1;
        Scanner scanner = new Scanner(System.in);
       out: while (true){
            for(int a=0;a<=red.length-1;a++){
                System.out.println("请输入您要购买的第"+(a+1)+"个红色球号码(1-33)");
                buy[a]=scanner.nextInt();
            }
            for (int b=0;b<buy.length;b++){
                if (buy[b]>33){
                    System.out.println("您输入的第"+(b+1)+"个红色球号码有误，请重新输入");
                    continue out;
                }
            }
            //检查是否输入重复号码
            for (int c=0;c<=buy.length-1;c++){
                for (int d=0;d<=buy.length-1;d++){
                    if (c==d){
                        continue;
                    }
                    if (buy[c]==buy[d]){
                        System.out.println("您输入的红色球号码有重复，请重新输入");
                        continue out;
                    }
                }
            }
            break;
        }
        while (true){
            System.out.println("请输入您要购买的蓝色球号码(1-15)");
            buy2=scanner.nextInt();
            if (buy2>15){
                System.out.println("您输入的蓝色球号码有误，请重新输入");
                continue;
            }
            break;
        }
        //判断购买的红球与开奖的相等的个数
        for (int a=0;a<=red.length-1;a++){
            for (int b=0;b<=buy.length-1;b++){
                if (red[a]==buy[b]){
                    yes++;
                }
            }
        }
        System.out.println("您购买的号码为："+buy[0]+" "+buy[1]+" "+buy[2]+" "+buy[3]+" "+buy[4]+" "+buy[5]+" "+"【"+buy2+"】");
        System.out.println("开奖号码为："+red[0]+" "+red[1]+" "+red[2]+" "+red[3]+" "+red[4]+" "+red[5]+" "+"【"+blue+"】");
        System.out.println("有"+yes+"个红球相等");
        if (blue==buy2){
            System.out.println("蓝色球相等");
        }else{
            System.out.println("蓝色球不相等");
        }
       if (yes==6&&blue==buy2){
           System.out.println("恭喜！您获得一等奖！");
       }else if (yes==6){
           System.out.println("恭喜！您获得二等奖！");
       }else if (yes==5&&blue==buy2){
           System.out.println("恭喜！您获得三等奖！");
       }else if (yes==5||(yes==4&&blue==buy2)){
           System.out.println("恭喜！您获得四等奖！");
       }else if (yes==4||(yes==3&&blue==buy2)){
           System.out.println("恭喜！您获得五等奖！");
       }else if (blue==buy2||(yes==2&&blue==buy2)||(yes==1&&blue==buy2)){
           System.out.println("恭喜！您获得六等奖！");
       }else {
           System.out.println("很遗憾，您未中奖~");
       }

    }
}
