package com.jiaflu.leetcode;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 解答：
 * - 双重循环
 *
 */

public class $560_Subarray_Sum_Equals_K {
    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1,-1,1}, 0));
    }
}
