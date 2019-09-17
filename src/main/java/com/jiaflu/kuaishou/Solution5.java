package com.jiaflu.kuaishou;

import java.util.Scanner;

/**
 * 集合划分
 * - 一个数组划分为两个集合,使两个集合的差的绝对值最小
 */

public class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        int mid = sum / 2;
        // 01 背包问题
        int[][] dp = new int[nums.length+1][mid + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= mid; j++) {
                if (nums[i] > j) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-nums[i]] + nums[i]);
                }
            }
        }

        int res = Math.abs(sum - dp[nums.length][mid] - dp[nums.length][mid]);
        System.out.println(res);

    }
}
