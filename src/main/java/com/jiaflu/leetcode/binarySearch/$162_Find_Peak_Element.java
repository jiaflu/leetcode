package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 条件：
 * - O(logN) 时间复杂度的。
 *
 * 解答：
 * - 判断往左查询还是往右查询的条件
 * 首先从数组 nums 中找到中间的元素 mid。
 * - 若该元素恰好位于降序序列或者一个局部下降坡度中（通过将 nums[i] 与右侧比较判断)，则说明峰值会在本元素的左边。
 * - 否则在上坡坡度中，峰值会在本元素的右边。
 *
 */

public class $162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
