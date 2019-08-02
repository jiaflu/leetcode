package com.jiaflu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 解答：
 * - 时间、空间复杂度比较高，有空优化
 */
public class $84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], heights[i]);
        }

        // 每个高度都遍历一遍，在高度固定的情况下，找出宽最大的
        int max_aera = 0;
        for (Integer key : map.keySet()) {
            int height = key;
            int cnt = 0, max_cnt = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= height) {
                    cnt++;
                } else {
                    if (cnt > max_cnt) {
                        max_cnt = cnt;
                    }
                    cnt = 0;
                }
            }
            max_cnt = Math.max(max_cnt, cnt);
            max_aera = Math.max(max_cnt * height, max_aera);
        }
        return max_aera;
    }
}
