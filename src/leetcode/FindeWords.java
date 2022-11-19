package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 500. 键盘行
 * @author 风亦未止
 * @date 2021/10/30 16:55
 */
public class FindeWords {
    public static void main(String[] args) {
        String[] s={"Hello","Alaska","Dad","Peace"};
        String[] words = findWords(s);
        System.out.println(Arrays.toString(words));

    }
    public static String[] findWords(String[] words) {
        List<String> result=new ArrayList<>();
        String s1="qwertyuiopQWERTYUIOP";
        String s2="asdfghjklASDFGHJKL";
        String s3="zxcvbnmZXCVBNM";
        for(int a=0;a<words.length;a++){
            int n1=0,n2=0,n3=0,leng=words[a].length();
            for(int b=0;b<leng;b++){
                if(s1.contains(words[a].charAt(b)+"")){
                    n1++;
                }else if(s2.contains(words[a].charAt(b)+"")){
                    n2++;
                }else{
                    n3++;
                }
            }
            if(n1==leng||n2==leng||n3==leng){
                result.add(words[a]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
