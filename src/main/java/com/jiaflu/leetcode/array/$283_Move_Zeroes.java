package com.jiaflu.leetcode.array;

/**
 * 题目：移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 解答：
 *
 *
 */
public class $283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swapArrays(nums, i, j);
                        break;
                    }
                }
            }
        }
    }
    private void swapArrays(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    // 双指针
    public void moveZeroes_(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swapArrays(nums, i, k);
                k++;
            }
        }
    }
    private void swapArrays_(int[] nums, int first, int second) {
        if (first == second) {
            return;
        }
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
