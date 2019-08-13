package com.jiaflu.leetcode.dp;

/**
 * 题目：地下城游戏
 *
 * 解答：
 * - 自底向上的动态规划（二维）
 * - 很难
 */

public class $174_Dungeon_Game {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row][col];
        // 初始化右下角最少血量
        dp[row][col] = Math.max(1-dungeon[row-1][col-1], 1);
        // 初始化最后一行
        for (int i = col-2; i>=0; i--) {
            dp[row-1][i] = Math.max(1, dp[row-1][i+1] - dungeon[row-1][i]);
        }
        // 初始化最后一列
        for (int i = row-2; i >= 0; i--) {
            dp[i][col-1] = Math.max(1, dp[i+1][col-1] - dungeon[i][col-1]);
        }
        // print(dp)
        for (int i = row-2; i >= 0; i--) {
            for (int j = col-2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
