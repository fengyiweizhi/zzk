package leetcode;

import java.util.Arrays;

/**
 * @author 风亦未止
 * @date 2022/2/23 14:50
 */
public class leetcode917 {
    public static void main(String[] args) {
        String s = reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(s);

    }
    public  static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while (i<j){
            while (i<j&&!Character.isLetter(chars[i])){
                i++;
            }
            while (i<j&&!Character.isLetter(chars[j])){
                j--;
            }
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
