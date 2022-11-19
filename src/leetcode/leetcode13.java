package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 风亦未止
 * @date 2022/2/22 15:38
 */
public class leetcode13 {
    public static void main(String[] args) {
        int iii = romanToInt("MCMXCIV");
        System.out.println(iii);
    }

    public static int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int result=0;
        for (int i=0;i<s.length();i++){
            if (i!=0&&i<s.length()-1&&(map.get(s.charAt(i)+"")<map.get(s.charAt(i-1)+""))&&(map.get(s.charAt(i)+"")<map.get(s.charAt(i+1)+""))){
                result-=map.get(s.charAt(i)+"");
            }else if (i==0&&(map.get(s.charAt(i)+"")<map.get(s.charAt(i+1)+""))){
                result-=map.get(s.charAt(i+i)+"");
            } else {
                result+=map.get(s.charAt(i)+"");
            }
        }
        return result;
    }
}
