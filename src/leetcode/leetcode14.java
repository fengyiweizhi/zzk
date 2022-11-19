package leetcode;

/**
 * @author 风亦未止
 * @date 2022/2/22 16:27
 */
public class leetcode14 {
    public static void main(String[] args) {
        String[] s={"flower","flow","flight"};
        String s1 = longestCommonPrefix(s);
        System.out.println(s1);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==1){
            return strs[0];
        }
        String s=strs[0];
        for (String ss:strs){
            while (!ss.startsWith(s)){
                if (s.length()==0){
                    return "";
                }
                s=s.substring(0,s.length()-1);
            }

        }
        return s;
    }
}
