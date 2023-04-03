package 杂题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s ，一个字符 互不相同 的字符串 chars 和一个长度与 chars 相同的整数数组 vals 。
 *
 * 子字符串的开销 是一个子字符串中所有字符对应价值之和。空字符串的开销是 0 。
 *
 * 字符的价值 定义如下：
 *
 * 如果字符不在字符串 chars 中，那么它的价值是它在字母表中的位置（下标从 1 开始）。
 * 比方说，'a' 的价值为 1 ，'b' 的价值为 2 ，以此类推，'z' 的价值为 26 。
 * 否则，如果这个字符在 chars 中的位置为 i ，那么它的价值就是 vals[i] 。
 * 请你返回字符串 s 的所有子字符串中的最大开销。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "adaa", chars = "d", vals = [-1000]
 * 输出：2
 * 解释：字符 "a" 和 "d" 的价值分别为 1 和 -1000 。
 * 最大开销子字符串是 "aa" ，它的开销为 1 + 1 = 2 。
 * 2 是最大开销。
 * 示例 2：
 *
 * 输入：s = "abc", chars = "abc", vals = [-1,-1,-1]
 * 输出：0
 * 解释：字符 "a" ，"b" 和 "c" 的价值分别为 -1 ，-1 和 -1 。
 * 最大开销子字符串是 "" ，它的开销为 0 。
 * 0 是最大开销。
 *
 * @author 风亦未止
 * @date 2023/4/1 23:13
 */
public class 找到最大开销的子字符串 {
    public static void main(String[] args) {


    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = vals.length;
        for (int i = 0; i < n; i++) {
            map.put(chars.charAt(i) - 'a', vals[i]);
        }
        int cur = 0;
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int temp = 0;
            if (map.get(s.charAt(i) - 'a') != null) {
                temp = cur + map.get(s.charAt(i) - 'a');
            } else {
                temp = cur + (s.charAt(i) - 'a' + 1);
            }
            if (temp < cur) {
                cur = 0;
            } else {
                cur = temp;
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public int maxCost(String s, String chars, int[] vals) {
        Map<Character, Integer> charToVal = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            charToVal.put(chars.charAt(i), vals[i]);
        }
        int n = s.length();
        int left = 0;
        Set<Character> windowChars = new HashSet<>();
        int windowValSum = 0;
        int maxValSum = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (charToVal.containsKey(c)) {
                windowValSum += charToVal.get(c);
                windowChars.add(c);
            } else {
                windowValSum += c - 'a' + 1;
            }
            while (windowChars.size() == chars.length()) {
                maxValSum = Math.max(maxValSum, windowValSum);
                char d = s.charAt(left);
                if (charToVal.containsKey(d)) {
                    windowValSum -= charToVal.get(d);
                    windowChars.remove(d);
                } else {
                    windowValSum -= d - 'a' + 1;
                }
            }
            left += 1;
        }

        return maxValSum;

    }
}