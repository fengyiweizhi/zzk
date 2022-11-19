package leetcode;

/**
 * @author 风亦未止
 * @date 2022/2/22 15:37
 */
public class leetcode09 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==reverse(x)){
            return true;
        }
        return false;

    }
    public long reverse(long x) {
        long rev=0;
        while (x!=0) {
            if (rev<Integer.MIN_VALUE/10||rev>Integer.MAX_VALUE/10) {
                return 0;
            }
            //回文本
            long digit=x%10;
            x/=10;
            rev=rev*10+digit;
        }
        return rev;
    }
}
