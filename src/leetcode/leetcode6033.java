package leetcode;

/**
 * @author 风亦未止
 * @date 2022/4/2 22:35
 */
public class leetcode6033 {
    public static void main(String[] args) {
        int i = minBitFlips(3, 4);
        System.out.println(i);
    }
    public static int minBitFlips(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int count=0;
        int s_length=s.length();
        int g_length=g.length();
        String s1="";
        for(int i=0;i<Math.abs(s_length-g_length);i++){
            s1+="0";
        }
        if (s_length<g_length){
            s=s1+s;
        }else {
            g=s1+g;
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=g.charAt(i)){
                count++;
            }
        }
        return count;

    }
}
