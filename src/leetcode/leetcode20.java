package leetcode;

/**
 *  '('，')'，'{'，'}'，'['，']'
 * @author 风亦未止
 * @date 2022/2/22 17:01
 */
public class leetcode20 {
    public static void main(String[] args) {
        boolean valid = isValid("(([]){})");
        System.out.println(valid);
    }

    private static boolean isValid(String s) {

        return false;
    }


//    public static boolean isValid(String s) {
//        boolean is=false;
//        int length=0;
//        if (s.length()%2!=0){
//            return is;
//        }
//        for (int i=0;i<s.length()-1;i+=2){
//            if (getS(s.charAt(i)+"").equals(s.charAt(i+1)+"")){
//                length++;
//            }
//        }
//        if (length==s.length()/2){
//            return true;
//        }else {
//            for(int i=0;i<s.length()/2;i++){
//                if (getS(s.charAt(i)+"").equals(s.charAt(s.length()-i-1)+"")){
//                    is=true;
//                }else {
//                    return false;
//                }
//            }
//            return is;
//        }
//    }
//
//    public static String getS(String s){
//        switch (s){
//            case "(":
//                return ")";
//            case "{":
//                return "}";
//            case "[":
//                return "]";
//            default:
//                return "";
//        }
//    }
}
