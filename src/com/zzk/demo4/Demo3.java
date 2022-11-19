package com.zzk.demo4;

/**
 * 字符串压缩
 * @author 风亦未止
 */
public class Demo3 {
    public static void main(String[] args) {
        String s="aabcccccddddd";
        System.out.println( compress(s));

    }
    public static String compress(String s){
        //分割原字符串为数组
        String[] s1=s.split("");
        int num=1;
        StringBuffer stringBuffer=new StringBuffer();
         for(int a=0;a<s1.length;){
             for (int b=a+1;b<s1.length;b++){
                 if (s1[a].equals(s1[b])){
                     num++;
                 }
             }
             stringBuffer.append(s1[a]);
             stringBuffer.append(num);
            a=a+num;
            num=1;
         }
        String text=stringBuffer.toString();
         //如果压缩后长度大于原字符串，则返回原字符串
         if (text.length()>s.length()){
             return s;
         }
        return text;
    }
}
