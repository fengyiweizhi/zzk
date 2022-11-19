package leetcode;

/**
 * @author 风亦未止
 * @date 2022/2/23 15:30
 */
public class leetcode58 {
    public static void main(String[] args) {
        int hello_world = lengthOfLastWord("luffy is still joyboy");
        System.out.println(hello_world);
    }
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
