package com.jiaflu.leetcode.dp;


import java.util.Arrays;

/**
 * 多重背包问题
 */

public class PackageMultiple {

    public static void main(String[] args) {
        int[] w = new int[]{2, 3, 4, 5}; // 商品的体积 2 3 4 5
        int[] v = new int[]{3, 4, 5, 6}; // 商品的价值 3 4 5 6
        int[] n = new int[]{1, 3, 2, 1}; // 每件商品的数量

        int bagV = 8; // 背包大小
        int[][] dp= new int[w.length+1][bagV+1];  // 动态规划表

        for (int i = 0; i < w.length; i++) { // 第 i 个物品
            for (int j = 1; j <= bagV; j++) { // 容量
                // 状态转移方程
                for (int k = 0; k*w[i] <= j && k <= n[i]; k++) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-k*w[i]] + k*v[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // 最优解
        System.out.println(dp[w.length][bagV]);
    }

}
