package com.jiaflu.sort;

import java.util.Arrays;

/**
 * 归并操作
 *
 * 算法描述
 * - 把长度为 n 的输入序列分成两个长度为 n/2 的子序列
 * - 对这两个子序列分别采用归并排序
 * - 将两个排序的子序列合并成一个最终的排序序列
 */

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[i])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

}
