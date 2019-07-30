package com.jiaflu.leetcode.twoPointers;

/**
 * 题目：盛水最多的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 解答:
 * 双重循环，待优化
 */

public class $11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmpMax = Math.min(height[i], height[j]) * (j - i);
                if (tmpMax > max) {
                    max = tmpMax;
                }
            }
        }

        return max;
    }
}
