package com.jiaflu.leetcode.array;

import java.util.Arrays;

/**
 * 题目：最短无序连续子数组
 *
 * 解答：
 *
 */


public class $581_Shortest_Unsorted_Continuous_Subarray {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        boolean flag = true;
        while (start < end && flag) {
            flag = false;
            if (temp[start] == nums[start]) {
                start++;
                flag = true;
            }
            if (temp[end] == nums[end]) {
                end--;
                flag = true;
            }
        }
        return start == end ? 0 : end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2}));
    }
}
