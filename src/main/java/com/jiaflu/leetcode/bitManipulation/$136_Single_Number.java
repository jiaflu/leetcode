package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 解答：
 * 高级方法
 * - 交换律：`a ^ b ^ c <=> a ^ c ^ b`
 * - 任何数于 0 异或为任何数
 * - 相同的数异或为 0：`n ^ n = 0`
 */
public class $136_Single_Number {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
