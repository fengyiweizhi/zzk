package acwing.数据结构.栈;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个表达式，其中运算符仅包含 +,-,*,/（加 减 乘 整除），可能包含括号，请你求出表达式的最终值。
 *
 * 注意：
 *
 * 数据保证给定的表达式合法。
 * 题目保证符号 - 只作为减号出现，不会作为负号出现，例如，-1+2,(2+2)*(-(1+1)+2) 之类表达式均不会出现。
 * 题目保证表达式中所有数字均为正整数。
 * 题目保证表达式在中间计算过程以及结果中，均不超过 231−1。
 * 题目中的整除是指向 0 取整，也就是说对于大于 0 的结果向下取整，例如 5/3=1，对于小于 0 的结果向上取整，例如 5/(1−4)=−1。
 * C++和Java中的整除默认是向零取整；Python中的整除//默认向下取整，因此Python的eval()函数中的整除也是向下取整，在本题中不能直接使用。
 * 输入格式
 * 共一行，为给定表达式。
 *
 * 输出格式
 * 共一行，为表达式的结果。
 *
 * 数据范围
 * 表达式的长度不超过 105。
 *
 * 输入样例：
 * (2+2)*(1+1)
 * 输出样例：
 * 8
 *
 * @author 风亦未止
 * @date 2022/12/4 22:12
 */
public class 表达式求值 {
    public static Stack<Integer> nums = new Stack<>();
    public static Stack<String> op = new Stack<>();

    public static void eval(){
        int num1 = nums.pop(),num2=nums.pop();
        String o = op.pop();
        int x = 0;
        if("+".equals(o)){
            x = num1+num2;
        }
        if("-".equals(o)){
            x = num2-num1;
        }
        if("*".equals(o)){
            x = num1*num2;
        }
        if("/".equals(o)){
            x = num2/num1;
        }
        nums.push(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        //优先级
        HashMap<String,Integer> m = new HashMap<>();
        m.put("+",1);
        m.put("-",1);
        m.put("*",2);
        m.put("/",2);
        int length = str.length();
        for(int i=0;i<length;i++){
            char c = str.charAt(i);
            if(c-'0'>=0&&c-'0'<=9){
                int x=0;
                int j=i;
                while(j<length&&str.charAt(j)-'0'>=0&&str.charAt(j)-'0'<=9){
                    x = x*10+(str.charAt(j)-'0');
                    j++;
                }
                nums.push(x);
                i=j-1;
            }else if(c=='('){
                op.push(String.valueOf(c));
            }else if(c==')'){
                //演算括号内
                while(!"(".equals(op.peek())){
                    eval();
                }
                //弹出“（”
                op.pop();
            }else{
                //当前的运算符优先级小于栈顶的运算符，则演算
                while(!op.empty()&&m.getOrDefault(op.peek(),0)>=m.get(String.valueOf(c))){
                    eval();
                }
                op.push(String.valueOf(c));
            }
        }
        while(op.size()!=0){
            eval();
        }
        System.out.println(nums.peek());
    }
}
