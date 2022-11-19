package leetcode;

/**
 * 字母的个数，根据空格拆分
 * @author 风亦未止
 * @date 2021/10/7 15:59
 */
public class WordNum {
    public static void main(String[] args) {
        int i = wordNum(", , , ,        a, eaefa");
        System.out.println(i);
    }
    public static int wordNum(String s){
        int count=0;
        String[] s1= s.split(" ");
        for (String s2: s1) {
            if (!"".equals(s2)){
               count++;
            }
        }
        return count;
    }
}
