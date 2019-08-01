package com.jiaflu.leetcode.dp;

/**
 * 题目：不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 解答：
 * - 空间位置型动态规划问题
 * - 到达当前位置 `[i][j]` 的路径数 = 从左边来的`[i][j-1]` + 从上边来的 `[i-1][j]`
 */
public class $62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
