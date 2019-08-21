package com.jiaflu.sort;

/**
 * 选择排序
 *
 * 算法描述
 * - 初始状态：无序区为R[1..n]，有序区为空；
 * - 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
 *   该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
 *   将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 *
 * 算法分析：
 * - 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 * - 稳定
 *
 *
 */

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 0; i < arr.length; i++) {
            int tempIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) { // 找到最小的数
                    tempIndex = j; // 将最小数的索引保存
                }
            }
            int temp = arr[tempIndex];
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 8, 9, 1, 7, 5, 0, 6};
        selectionSort(arr);
        for(int i = 0; i < arr.length;++i){
            System.out.print(arr[i]+" ");
        }
    }

}
