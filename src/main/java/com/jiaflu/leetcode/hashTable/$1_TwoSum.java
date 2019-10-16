package com.jiaflu.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 解答：
 * - HashMap，key 存放值，value 存放原数组中的位置，然后原数组排序;
 * - 但需要考虑一种情况，就是出现重复元素的时候。解决办法就是一边遍历一遍把数存放到哈希表里。
 */


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
