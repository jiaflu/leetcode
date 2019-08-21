package com.jiaflu.sort;

/**
 * 冒泡排序
 *
 * 算法描述：
 * - 比较相邻的元素,如果它们的顺序错误就交换位置;
 * - 对每一对相邻元素作同样的工作,从开始第一对到结尾的最后一对,这样在最后的元素应该会是最大（最小）的数;
 * - 针对所有的元素重复以上的步骤,除了最后一个;
 * - 重复步骤1~3,直到排序完成。
 *
 * 优化：
 * - 若一次遍历没有出现交换,则已经有序,可结束
 *
 * 算法分析：
 * - 最佳情况：T(n) = O(n)
 * - 最差情况：T(n) = O(n2)
 * - 平均情况：T(n) = O(n2)
 *
 * - 稳定
 *
 */

public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {  // 细节
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[i];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 8, 9, 1, 7, 5, 0, 6};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
