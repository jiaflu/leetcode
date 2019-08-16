package com.jiaflu.leetcode;

import java.util.TreeMap;

/**
 * 题目：区间和的个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 解答：
 * - 不会
 */

public class $327_Count_of_Range_Sum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int total = 0;
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            // [0,i] 区间之和在所给区间范围内
            if (sum[i] >= lower && sum[i] <= upper) {
                total++;
            }
            for (Integer count : treeMap.subMap(sum[i] - upper, true, sum[i] - lower, true).values()) {
                total += count;
            }
            Integer count = treeMap.get(sum[i]);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            treeMap.put(sum[i], count);
        }
        return total;
    }

}
