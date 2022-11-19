package leetcode;

/**
 * @author 风亦未止
 * @date 2022/11/17 11:42
 */
public class leetcode792匹配子序列的单词数 {
    public static void main(String[] args) {
        int abcde = numMatchingSubseq("abcde", new String[]{"acd", "ace"});
        System.out.println(abcde);
    }
    public static int numMatchingSubseq(String s, String[] words) {
        int length=s.length();
        int ans=0;
        for(String str:words){
            String temp=s;
            char[] c=str.toCharArray();
            int n=c.length;
            int flag=0;
            for(int i=0;i<n;i++){
                if(temp.indexOf(c[i])==-1){
                    break;
                }else{
                    temp=temp.substring(temp.indexOf(c[i])+1,temp.length());
                    flag++;
                }
            }
            if(flag==n)ans++;
        }
        return ans;
    }
}
