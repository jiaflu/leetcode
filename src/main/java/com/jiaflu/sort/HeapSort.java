package com.jiaflu.sort;


/**
 * 堆排序
 * - 利用堆这种数据结构所设计的一种排序算法
 * - 堆是一个近似完全二叉树的结构
 * - 性质：子节点的键值或索引小于（大于）它的父节点
 *
 * 算法描述
 * - 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * - 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * - 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 *   然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 *   不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 算法分析
 * - 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
 */

public class HeapSort {
    // 声明全局变量,用于记录数组 array 的长度
    static int len;

    public static int[] HeapSort(int[] arr) {
        len = arr.length;
        if (len < 1) return arr;
        // 构建一个最大堆
        buildMaxHeap(arr);
        // 循环将堆首（最大位）与末位交换,然后再重新调正最大堆
        while (len > 0) {
            swap(arr, 0, len-1);
            len--;
            adjustHeap(arr, 0);
        }
        return arr;
    }

    public static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    public static void adjustHeap(int[] arr, int i) {
        int maxIndex = 1;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i*2 < len && arr[i*2] > arr[maxIndex])
            maxIndex = i*2;
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i*2+1 < len && arr[i*2+1] > arr[maxIndex])
            maxIndex = i*2+1;
        if (maxIndex != i) {
            swap(arr, maxIndex, i);
            adjustHeap(arr, maxIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
