package com.jiaflu.leetcode.sort;

import java.util.LinkedList;
import java.util.Stack;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        // 表示已经完成一个组
        if (left >= right) {
            return;
        }
        int index = partSort(arr, left, right);
        quickSort(arr, left, index-1);
        quickSort(arr, index+1, right);
    }


    public static void quickSortNotR(int[] arr, int left, int right) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(left);
        queue.addLast(right);
        while (!queue.isEmpty()) {
            left = queue.pollFirst();
            right = queue.pollFirst();
            if (left >= right) {
                continue;
            }
            int index = partSort(arr, left, right);
            queue.addLast(left);
            queue.addLast(index-1);
            queue.addLast(index+1);
            queue.addLast(right);
        }
    }

    private static int partSort(int[] arr, int left, int right) {
        // 以最左边的数(left)为基准
        int key = arr[left];
        while (left < right) {
            // 从序列右端开始，向左遍历，直到找到小于 key 的数
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            // 从序列左端开始，向右遍历，直到找到大于 key 的数
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,7,6,9,2,8,0,3,5};
        //quickSort(arr, 0, arr.length-1);
        quickSortNotR(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
