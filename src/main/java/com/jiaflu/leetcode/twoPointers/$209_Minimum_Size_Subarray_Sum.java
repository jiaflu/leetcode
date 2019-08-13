package com.jiaflu.leetcode.twoPointers;

/**
 * 题目：长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 解答：
 * - 双指针
 */

public class $209_Minimum_Size_Subarray_Sum {
    // 时间复杂度 O(n²),垃圾方法
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, count = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= s) {
                    if (min > count) {
                        min = count;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    // 双指针
    public int minSubArrayLen_(int s, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        int i = 0, start = 0;
        while (i < nums.length) {
            if (sum + nums[i] < s) {
                sum += nums[i];
                i++;
            } else {
                min = Math.min(min, i - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
