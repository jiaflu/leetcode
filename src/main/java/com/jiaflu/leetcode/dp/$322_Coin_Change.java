package com.jiaflu.leetcode.dp;

/**
 * 题目：零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 解答：
 * - dfs 会超时
 * - dp
 * - 看题解
 *
 */
public class $322_Coin_Change {
    static int res = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1); // 关键公式
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

//    int coinChange(vector<int>& coins, int amount) {
//        vector<int> dp(amount + 1, amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins)
//                if (coin <= i)
//                    dp[i] = min(dp[i], dp[i - coin] + 1);
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }


    // 暴力解法，超时
    private static int search(int[] coins, int amount) {
        if (amount == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = search(coins, amount-coin);
            // 子问题无解
            if (subProb == -1) continue;
            ans = Math.min(ans, subProb + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static void dfs(int[] coins, int amount, int cnt) {
        if (amount == 0) {
            if (res > cnt) {
                res = cnt;
            }
        } else if (amount < 0 || cnt >= res) {
            return;
        }
        for (int i = coins.length-1; i >= 0; i++) {
            dfs(coins, amount - coins[i], cnt+1);
        }
    }




    public static void main(String[] args) {

    }


}
