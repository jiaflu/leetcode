package com.jiaflu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 解答：
 * - map.getOrDefault()
 */
public class $169_Majority_Element {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], cnt);
            if (cnt > max) {
                max = cnt;
                maxIndex = nums[i];
            }
        }
        return maxIndex;
    }
}
