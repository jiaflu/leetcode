package com.jiaflu.leetcode.twoPointers;

/**
 * 题目：删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 解答：
 * - 返回不重复的数组
 * - 使用指针 next 标记当前值存储的位置
 */

public class $26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int cnt = 0, next = 0;
        for (int i = 0; i < nums.length;) {
            int temp = nums[i];
            cnt++;
            int index = i + 1;
            while (index < nums.length && temp == nums[index]) {
                index++;
            }
            nums[next++] = temp;
            i = index;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
