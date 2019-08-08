package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 解答：
 * - 位操作，类似 只出现一次的数字（其余两次）
 * - `0 ^ x = x`
 * - `x ^ x = 0`
 * - 注意别漏 nums.length
 */

public class $268_Missing_Number {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
