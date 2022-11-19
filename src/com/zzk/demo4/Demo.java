package com.zzk.demo4;

/**
 * 字母顺序翻转
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) {
        reversal("I like writing code best");

    }
    public static void reversal(String string){
        //从空格拆分,并放在数组中
        String[] strings=string.split(" ");
        for(int a=0;a<strings.length-1;a++){
            StringBuilder stringBuilder = new StringBuilder(strings[a]);
            stringBuilder.reverse();
            System.out.print(stringBuilder+" ");
        }
    }

}
