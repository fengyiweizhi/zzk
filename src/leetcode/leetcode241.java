package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 *输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 思路就是遍历字串，当遇到一个运算符，就把字串拆分成两块分别递归，最后将返回的所有结果组合用当前的运算符运算后保存。
 * 由于会有重复计算的字串，因此可以使用一个map来存储计算过的字串。
 * @author 风亦未止
 * @date 2022/2/20 15:08
 */
public class leetcode241 {
    public static void main(String[] args) {
        List<Integer> integers = diffWaysToCompute("2*3-4*5");
        System.out.println(integers);
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();
        for (int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if (c=='-'||c=='*'||c=='+'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l:left){
                    for (int r:right){
                        if (c=='-'){
                            res.add(l-r);
                        }else if(c=='+'){
                            res.add(l+r);
                        }else {
                            res.add(l*r);
                        }
                    }
                }
            }
        }
        if (res.size()==0){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }

// 带备忘录的：

//    Map<String, List<Integer>> map = new HashMap<>();
//
//    public List<Integer> diffWaysToCompute(String input) {
//
//        if (map.containsKey(input))
//            return map.get(input);
//
//        List<Integer> res = new LinkedList<>();
//
//        for (int i = 0; i < input.length(); i++) {
//
//            char ch = input.charAt(i);
//            if (ch == '+' || ch == '-' || ch == '*') {
//
//                List<Integer> left = diffWaysToCompute(input.substring(0, i));
//                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
//
//                for (int l : left) {
//
//                    for (int r : right) {
//
//                        if (ch == '+')
//                            res.add(l + r);
//                        else if (ch == '-')
//                            res.add(l - r);
//                        else
//                            res.add(l * r);
//                    }
//                }
//            }
//        }
//        if (res.size() == 0)
//            res.add(Integer.parseInt(input));
//
//        map.put(input, res);
//
//        return res;
//    }
}
