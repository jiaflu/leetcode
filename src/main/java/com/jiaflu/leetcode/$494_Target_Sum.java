package com.jiaflu.leetcode;

/**
 * 题目：目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 解答：
 * - dfs
 * - dp
 */
public class $494_Target_Sum {
    /**
     * dfs
     */
    static int cnt = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        cnt = 0;
        search(nums, 0, 0, S);
        return cnt;
    }
    private static void search(int[] nums, int sum, int index, int s) {
        if (index == nums.length && sum == s) {
            cnt++;
            return;
        } else if (index >= nums.length) {
            return;
        }
        search(nums, sum+nums[index], index+1, s);
        search(nums, sum-nums[index], index+1, s);
    }

    /**
     * dp
     */
    public static int findTargetSumWays_(int[] nums, int S) {
        int[][] dp = new int[nums.length+1][S+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= S; j++) {

            }
        }

        cnt = 0;
        search(nums, 0, 0, S);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
