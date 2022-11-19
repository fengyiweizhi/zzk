package leetcode;

/**
 * @author 风亦未止
 * @date 2022/2/23 15:14
 */
public class leetcode28 {
    public static void main(String[] args) {
        int i = strStr("aa", "bb");
        System.out.println(i);

    }
    public static int strStr(String haystack, String needle) {


        if (haystack.equals("")&&needle.equals("")){
            return 0;
        }
        int index = haystack.indexOf(needle);

//        for (int i=0;i<haystack.length();i++){
//            if (haystack.startsWith(needle,i)){
//                return i;
//            }
//        }
        return index;
    }
}
