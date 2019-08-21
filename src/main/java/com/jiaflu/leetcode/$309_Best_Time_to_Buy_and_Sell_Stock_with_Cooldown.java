package com.jiaflu.leetcode;

/**
 * 题目：最佳买卖股票时机含冷冻期
 *
 * 解答：
 *
 */

public class $309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] hold = new int[n];
        hold[0] = -prices[0];
        int[] notHold = new int[n];
        for (int i = 1; i < n; i++) {
            if (i > 2) {
                hold[i] = Math.max(hold[i-1], notHold[i-2] - prices[i]);
            } else {
                hold[i] = Math.max(hold[i-1],-prices[i]);
            }
            notHold[i]=Math.max(notHold[i-1],hold[i-1]+prices[i]);
        }
        return notHold[n-1];
    }
}
