package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 解答：
 * - 遍历一遍...
 * - 二分查找
 */

public class $33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
