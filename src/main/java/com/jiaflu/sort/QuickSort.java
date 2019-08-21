package com.jiaflu.sort;

/**
 * 快排
 * - 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 *   则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 算法描述
 * - 从数列中挑出一个元素，称为 “基准”（pivot）；
 * - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *   在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 算法分析：
 * - 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
 */

public class QuickSort {


    public static void sorts(int[] arr, int head, int tail) {
        if (head > tail) return;
        int temp = arr[head]; // 作为基准
        int i = head, j = tail;
        while (i < j) {
            while (arr[j] > temp && i < j) j--;
            arr[i] = arr[j];
            while (arr[i] < temp && i < j) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        sorts(arr, head, i - 1);
        sorts(arr, i+1, tail);
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 8, 9, 1, 7, 5, 0, 6};
        sorts(a, 0, a.length - 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
    }

}
