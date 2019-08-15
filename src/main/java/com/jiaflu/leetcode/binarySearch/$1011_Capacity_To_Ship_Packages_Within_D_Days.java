package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：在 D 天内送达包裹的能力
 *
 * 解答：
 * - 二分查找
 * - 看题目注解注意细节
 */

public class $1011_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
            if (left < weights[i]) {
                left = weights[i];
            }
        }
        int mid = 0;
        while (left < right) {// 细节1
            mid = left + (right - left) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] <= mid) {
                    sum += weights[i];
                } else {
                    count++;
                    sum = weights[i];
                }
            }
            if (count <= D) { // 细节2，当找到一个合适的值后还需要缩小范围
                right = mid;
            } else if (count > D) {
                left = mid + 1;
            }
        }
        return left;
    }
}
