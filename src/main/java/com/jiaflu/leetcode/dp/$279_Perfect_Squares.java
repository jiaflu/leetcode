package com.jiaflu.leetcode.dp;

/**
 * 题目：完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 解答：
 * - 动态规划
 */
public class $279_Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                if (j*j == i) {
                    min = 1;
                    break;
                }
                min = Math.min(min, dp[j*j] + dp[i - j*j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
