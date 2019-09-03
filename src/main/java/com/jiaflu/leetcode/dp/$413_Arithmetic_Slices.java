package com.jiaflu.leetcode.dp;

/**
 * 题目：等差数列划分
 * - 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 解答：
 * - dp,状态转移方程如下
 * - 对于第 i 个元素,判断这个元素跟前一个元素的差值是否和等差数列中的差值相等
 *   - 如果相等,那么新区间中等差数列即为 1+dp[i-1],sum 同时也要加上这个值来更新全局的等差数列总数。
 */

public class $413_Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
