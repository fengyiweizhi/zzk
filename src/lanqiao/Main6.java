package lanqiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 单词分析
 * @author 风亦未止
 * @date 2021/12/23 20:19
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String next = scan.next();
        int[] word=new int[26];
        for (int a=0;a<word.length;a++){
            word[a]=0;
        }
       for (int a=0;a<next.length();a++){
           //存字母出现的次数
           word[next.charAt(a)-97]++;
       }
       int num=1;
       char maxchar=97;
        for (int a=0;a<next.length();a++){
           num=Math.max(num,word[next.charAt(a)-97]);
           if (num==word[next.charAt(a)-97]){
               maxchar= next.charAt(a);
           }
           if (num==1){
               maxchar= (char) Math.min(maxchar,next.charAt(a));
           }
        }
        System.out.println(maxchar);
        System.out.println(num);
        scan.close();
    }

}
