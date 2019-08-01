package com.jiaflu.leetcode.dp;

/**
 * 题目：编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 解答：
 * - 动态规划
 * - `dp[i][j]` 代表 `word1` 到 `i` 位置转换成 `word2` 到`j` 位置需要最少步数
 *   - 当 `word1[i] == word2[j]` , `dp[i][j] = dp[i-1][j-1]`;
 *   - 当 `word1[i] != word2[j]`，`dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1`;
 * - 其中，`dp[i-1][j-1]` 表示替换操作，`dp[i-1][j]` 表示删除操作，`dp[i][j-1]` 表示插入操作。
 *
 */
public class $72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 若有一个 string 为空
        if (m * n == 0) {
            return m + n;
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
        return dp[m][n];
    }
}
