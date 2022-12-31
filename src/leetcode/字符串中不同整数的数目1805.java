package leetcode;

import java.util.HashSet;

/**
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * <p>
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * <p>
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * <p>
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 *
 * @author 风亦未止
 * @date 2022/12/6 14:34
 */
public class 字符串中不同整数的数目1805 {
    public static void main(String[] args) {
        int i = numDifferentIntegers("a1b01c001");
        System.out.println(i);
    }

    public static int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) - '0' >= 0 && word.charAt(i) - '0' <= 9) {
                StringBuilder x = new StringBuilder();
                int j = i;
                while (j < length && word.charAt(j) - '0' >= 0 && word.charAt(j) - '0' <= 9) {
                    x.append(("".equals(x.toString())&&word.charAt(j)=='0')?"":word.charAt(j));
                    j++;
                }
                set.add(x.toString());
                i = j - 1;
            }
        }
        return set.size();

    }
}
