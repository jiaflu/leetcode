package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 解答:
 * - 二分搜索
 * - 注意边界位置
 */

public class $35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        }
        return mid;
    }
}
