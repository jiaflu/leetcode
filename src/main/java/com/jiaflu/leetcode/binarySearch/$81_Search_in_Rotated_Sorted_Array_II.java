package com.jiaflu.leetcode.binarySearch;

/**
 * 题目:搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 解答：
 * - 先遍历找到旋转的点,在遍历过程中顺便比较是否 target 相等
 * - 后半段二分查找
 *
 */

public class $81_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
            if ( i-1 >=0 && nums[i] > nums[i-1]) {
                left = i;
                break;
            }
        }
        // 特殊情况如：[1]
        if (left == -1) return false;

        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
