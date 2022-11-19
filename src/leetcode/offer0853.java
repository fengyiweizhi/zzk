package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author 风亦未止
 * @date 2022/2/15 22:58
 */
public class offer0853 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list.toString());
    }
    public static List<String> generateParenthesis(int n) {
        List<List<String>> result=new ArrayList<>();
        List<String> list0=new ArrayList<>();
        list0.add("");
        List<String> list1=new ArrayList<>();
        list1.add("()");
        result.add(list0);
        result.add(list1);
        for(int i=2;i<=n;i++){
            List<String> temp=new ArrayList<>();
            for (int j=0;j<i;j++){
                List<String> list = result.get(j);
                List<String> list2 = result.get(i-j-1);
                for (String s1:list){
                    for (String s2: list2) {
                        temp.add("("+s1+")"+s2);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }
}
