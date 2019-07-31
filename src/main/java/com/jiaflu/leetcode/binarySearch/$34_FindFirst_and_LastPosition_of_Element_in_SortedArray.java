package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 解答：
 * - 注意数组越界
 * - 注意数组中只有一个数的情况
 *
 */

public class $34_FindFirst_and_LastPosition_of_Element_in_SortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int index = -1;
        // 排序数组，二分查找
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        int[] result = new int[2];
        if (index == -1) {
            result[0] = -1;
            result[1] = -1;
        } else {
            l = index;
            r = index;
            while (l > 0 && nums[l-1] == target) l--;
            while (r < nums.length-1 && nums[r+1] == target) r++;
            result[0] = l;
            result[1] = r;
        }
        return result;
    }
}
