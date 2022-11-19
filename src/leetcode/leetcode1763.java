package leetcode;

/**
 * 1763. 最长的美好子字符串
 *
 * @author 风亦未止
 * @date 2022/2/10 16:39
 */
public class leetcode1763 {
    public static void main(String[] args) {
        String aA = longestNiceSubstring("aqAaaA");
        System.out.println(aA);
    }
    public static String longestNiceSubstring(String s) {
        int length = s.length();
        if (length==1){
           return "";
        }
        int maxlength=0;
        int beginIndex=0;
        for (int i=0;i<length;i++){
            int low=0;
            int high=0;
            for(int j=i;j<length;j++){
                if(Character.isLowerCase(s.charAt(j))){
                    low|=1<<(s.charAt(j)-'a');
                }else {
                    high|=1<<(s.charAt(j)-'A');
                }
                if (low==high&&j-i+1>maxlength){
                    beginIndex=i;
                    maxlength=j-i+1;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxlength);

    }
}
