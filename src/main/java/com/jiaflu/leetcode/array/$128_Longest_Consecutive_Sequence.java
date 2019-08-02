package com.jiaflu.leetcode.array;

import java.util.Arrays;

/**
 * 题目：最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *  解答：
 * - 排序 + 去重
 *
 */

public class $128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max_length = 0;
        if (nums.length == 0 || nums == null) {
            return max_length;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                count++;
            } else if (nums[i-1] == nums[i]) {
                // 去重
                continue;
            } else {
                if (max_length < count) {
                    max_length = count;
                }
                count = 1;
            }
        }
        if (max_length < count) {
            max_length = count;
        }
        return max_length;
    }
}
