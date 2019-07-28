package com.jiaflu.leetcode;

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
