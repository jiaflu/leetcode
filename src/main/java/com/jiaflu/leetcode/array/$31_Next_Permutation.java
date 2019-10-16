package com.jiaflu.leetcode.array;

import java.util.Arrays;

/**
 * 题目：下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 解答：
 * 理清思路：先从后往前找出第一个非降序排列的数字 `nums[index]`，
 * 在这个数字后面的区间`nums[index+1] ~ nums[nums.length-1]`中找出最小的比`nums[index]`大的数，交换位置，
 * 升序排序`nums[index+1]~nums[nums.length]`
 */

public class $31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]){
                index = i - 1;
                break;
            }
        }
        if (index != -1) {
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    break;
                }
            }
            Arrays.sort(nums, index + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        System.out.println( 8 >> 1);
    }
}
