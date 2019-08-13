package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 解答：
 *
 */

public class $167_Two_Sum_II_Input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int[] res = new int[2];
        for (; i < numbers.length-1; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int flag = binarySearch(i, left, right, target, numbers);
            if (flag != -1) {
                res[0] = i + 1;
                res[1] = flag + 1;
                break;
            }
        }
        return res;
    }

    private int binarySearch(int i, int left, int right, int target, int[] numbers) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[i] + numbers[mid] < target) {
                left = mid + 1;
            } else if (numbers[i] + numbers[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
