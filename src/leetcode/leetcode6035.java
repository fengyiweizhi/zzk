package leetcode;

/**
 * @author 风亦未止
 * @date 2022/4/2 23:20
 */
public class leetcode6035 {
    public static void main(String[] args) {
        long l = numberOfWays("001101");
        System.out.println(l);
    }
    public static long numberOfWays(String s) {
        int length = s.length();
        int prcount=0;
        int edcount=0;
        int count=0;
        long res=0;
        for (int i=0;i<length-2;i++){
            char c =s.charAt(i);
            for(int j=i+1;j<length;j++){
                if(c-'0'!=s.charAt(j)-'0'){
                    c =s.charAt(i);
                    count++;
                    prcount++;
                }
            }
            if (count==2){
                res+=prcount*edcount;
                count=0;
            }else {
                continue;
            }
        }
        return res;

    }
}
