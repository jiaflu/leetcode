package com.jiaflu.sort;

/**
 * 插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 算法描述
 * - 从第一个元素开始，该元素可以认为已经被排序；
 * - 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * - 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * - 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * - 将新元素插入到该位置后；
 * - 重复步骤2~5。
 *
 * 算法分析：
 * - 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        if (arr.length == 0) return arr;
        int current;
        for (int i = 0; i < arr.length-1; i++) {
            current = arr[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 8, 9, 1, 7, 5, 0, 6};
        insertionSort(arr);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
