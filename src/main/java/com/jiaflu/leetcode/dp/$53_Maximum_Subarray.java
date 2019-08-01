package com.jiaflu.leetcode.dp;

/**
 * 题目：最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 解答：
 * - 动态规划
 * - 对数组遍历，当前最大连续序列和为 sum，结果为 ans
 * - 如果 `sum > 0`，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * - 如果 `sum < 0`，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * - 每次比较 `sum` 和 `ans` 的大小，将最大值置为 `ans`，遍历结束返回结果
 * - 时间复杂度：O(n)
 */

public class $53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
