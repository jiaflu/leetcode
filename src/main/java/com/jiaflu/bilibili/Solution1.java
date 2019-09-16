package com.jiaflu.bilibili;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word1 = in.nextLine();
        String word2 = in.nextLine();
        int m = word1.length();
        int n = word2.length();

        // 若有一个 string 为空
        if (m * n == 0) {
            System.out.println(m+n);
        }

        // dp[i][j] 表示 word1 前 i 个字母和 word2 的前 j 个字母之间的距离
        int[][] dp = new int[m+1][n+1];

        // 初始化边界
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i][j-1] + 1;
                int up = dp[i-1][j] + 1;
                int left_up = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j - 1)) {
                    left_up += 1;
                }
                dp[i][j] = Math.min(left, Math.min(up, left_up));
            }
        }
        System.out.println(dp[m][n]);
    }
}
