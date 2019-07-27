package com.jiaflu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class $1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (map.containsKey(target - a)) {
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            }
            map.put(a, i);
        }
        return null;
    }
}
