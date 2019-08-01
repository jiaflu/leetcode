package com.jiaflu.leetcode.dp;

/**
 * 题目：爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 解答：
 * - 动态规划
 * - 递归会超时
 */
public class $70_Climbing_Stairs {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
