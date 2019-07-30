package com.jiaflu.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 解答：
 * - 固定一个节点，而后使用双指针
 */

public class $15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; // 去重
            int l = i + 1, r = nums.length - 1;
            if (nums[l] < 0 && Integer.MIN_VALUE  > nums[i] + nums[l]) continue; // 如果溢出最小值则跳过
            if (nums[i] > 0 && Integer.MAX_VALUE < nums[i] + nums[l]) break; // 溢出最大值直接结束，不可能会有新的三元组出现

            while (l < r) {
                if (nums[l]+ nums[i] + nums[r] > 0) {
                    while (l < r && nums[r - 1] == nums[r]) r--; // 右指针去重
                    r--;
                } else if (nums[l] + nums[i] + nums[r] < 0) {
                    while (l < r && nums[l + 1] == nums[l]) l++; // 左指针去重
                    l++;
                } else {
                    tuples.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r - 1] == nums[r]) r--; // 右指针去重
                    while (l < r && nums[l + 1] == nums[l]) l++; // 左指针去重
                    r--;
                    l++;
                }
            }
        }
        return tuples;
    }

}
