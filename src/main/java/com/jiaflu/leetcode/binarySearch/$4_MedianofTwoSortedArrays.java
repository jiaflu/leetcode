package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例：
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 解答：
 * - 把控时间复杂度
 * - 求出中位数位置之后把两个数组慢慢合并，合并到中位数即可
 */

public class $4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt = nums1.length + nums2.length;
        int[] nums = new int[cnt];
        int c = 0;
        boolean flag;
        if (cnt % 2 == 1) { // 奇数
            int index = cnt / 2;
            int a = 0, b = 0;
            while (a < nums1.length || b < nums2.length) {
                if (index < c) {
                    break;
                }
                if (a < nums1.length && b < nums2.length) {
                    if (nums1[a] <= nums2[b]) {
                        nums[c++] = nums1[a++];
                    } else {
                        nums[c++] = nums2[b++];
                    }
                } else if (a < nums1.length) {
                    nums[c++] = nums1[a++];
                } else {
                    nums[c++] = nums2[b++];
                }
            }
            return (double) nums[index];
        } else {
            int index2 = cnt / 2;
            int index1 = index2 -1;
            int a = 0, b = 0;
            while (a < nums1.length || b < nums2.length) {
                if (index2 < c) {
                    break;
                }
                if (a < nums1.length && b < nums2.length) {
                    if (nums1[a] <= nums2[b]) {
                        nums[c++] = nums1[a++];
                    } else {
                        nums[c++] = nums2[b++];
                    }
                } else if (a < nums1.length) {
                    nums[c++] = nums1[a++];
                } else {
                    nums[c++] = nums2[b++];
                }
            }
            return (double) (nums[index1] + nums[index2]) / 2;
        }
    }
}
