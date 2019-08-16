package com.jiaflu.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *
 * 解答：
 * - 双指针 + 排除法
 */

public class $658_Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-1;
        int cnt = arr.length;
        while (cnt > k) {
            if (x - arr[left] > arr[right] - x) {
                left++;
                cnt--;
            } else {
                right--;
                cnt--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
