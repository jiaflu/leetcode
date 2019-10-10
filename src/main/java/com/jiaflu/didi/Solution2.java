package com.jiaflu.didi;

import java.util.Scanner;

/**
 * 题目：
 * 测试用例：
 * 5 10000 1000
 * 1 5 4 2 3
 * 5 4 3 2 1
 *
 * 解答：
 * - dp
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int total = in.nextInt();
            int cost = in.nextInt();
            int times = total / cost; // 直接转换成可搬的次数
            int[] aNums = new int[n];
            int[] bNums = new int[n];
            for (int i = 0; i < n; i++) {
                //aNums[n - i - 1] = in.nextInt();
                aNums[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                //bNums[n - i - 1] = in.nextInt();
                bNums[i] = in.nextInt();
            }

            int[][] dp = new int[n + 1][n + 1];

            int rest = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (aNums[i - 1] == bNums[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        // 计算最后无前缀末尾元素匹配的时候剩下的个数
                        if (2 * n - i - j < rest) {
                            rest = 2 * n - i - j;
                        }
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }


            if (rest + dp[n][n] > times) {
                dp[n][n] -= rest + dp[n][n] - times;
            }

            System.out.println(dp[n][n] > 0 ? dp[n][n] : 0);

        }
    }
}
