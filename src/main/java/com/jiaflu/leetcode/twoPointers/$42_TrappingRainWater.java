package com.jiaflu.leetcode.twoPointers;

/**
 * 题目：接雨水
 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 解答：
 * - 遍历每一列，然后分别求出这一列两边最高的墙，找出较矮的一端，和当前列的高度比较。
 */

public class $42_TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        // 最两端的列不用考虑，因为一定不会有水，所以下标从 1 到 length-2
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            // 找出左边最高端
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            // 找出右边最高端
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            // 找出两端最小的，只有较小的一端大于当前列的高度才会有水
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
}
