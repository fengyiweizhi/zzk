package com.zzk.demo4;

import java.util.Arrays;

/**
 * trim方法
 * @author 风亦未止
 */
public class Demo4 {
    public static void main(String[] args) {
        String s=" hello ";
        String s2="     ";
        System.out.println(trim(s));
        System.out.println(trim(s2));
    }
    public static String trim(String s){
        String[] ss=s.split("");
        int nullNum=0;
        for (int a = 0;a<ss.length;a++) {
            if (ss[a].equals(" ")) {
                nullNum++;
            }
            if (nullNum == ss.length) {
                return "";
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (int b = 0;b<ss.length;b++){
            if (ss[b].equals(" ")){
                nullNum++;
            }
            if (nullNum==ss.length){
                return null;
            }
            if (ss[0].equals(" ")){
                ss[0]="";
            }
            if (ss[ss.length-1].equals(" ")){
                ss[ss.length-1]="";
            }
            stringBuffer.append(ss[b]);
        }
        String result=stringBuffer.toString();
        return result;
    }

}
