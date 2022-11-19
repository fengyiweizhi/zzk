package lanqiao;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 风亦未止
 * @date 2022/11/6 12:25
 */
public class 前K个高频元素 {
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int length=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> collect = entries.stream().sorted((a, b) -> {
            return b.getValue() - a.getValue();
        }).collect(Collectors.toList());
        int size = collect.size();
        int index=0;
        int[] res=new int[k];
        while(index<k){
            Map.Entry<Integer, Integer> integerIntegerEntry = collect.get(index);
            res[index]=integerIntegerEntry.getKey();
            index++;
        }
        return res;
    }

}
