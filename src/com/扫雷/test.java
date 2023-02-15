package com.扫雷;

import java.util.*;
import java.util.stream.Collectors;

class Solution {


    public static void main(String[] args) {

        int minSwaps = getMinSwaps(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(minSwaps);

    }
    public static int getMinSwaps(ArrayList<Integer> nums){
        HashMap<Integer, Integer> mp=new HashMap<>();
        List<Integer> collect = nums.stream().sorted((a, b) -> {
            return a - b;
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size();i++){
            mp.put(collect.get(i),i);
        }
        int cnt = 0;
        for (int i = 0; i < nums.size();i++)
        {
            if (nums.get(i)== collect.get(i))continue;
            cnt++;
        }
        return cnt;
    }

}
