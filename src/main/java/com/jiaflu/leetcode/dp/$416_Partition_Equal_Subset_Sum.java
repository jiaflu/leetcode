package com.jiaflu.leetcode.dp;

/**
 * 题目：分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 解答：
 * - 转化内为 01 背包问题
 * - nums 即为物品重量也为价值
 * - 体积为  sum / 2;
 *
 */


public class $416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        // 01 背包问题
        int[][] dp = new int[nums.length+1][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i] > j) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-nums[i]] + nums[i]);
                }
            }
        }
        if (dp[nums.length][sum] == sum) {
            return true;
        } else {
            return false;
        }

    }
}
