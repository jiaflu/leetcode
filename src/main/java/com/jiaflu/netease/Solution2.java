package com.jiaflu.netease;

import java.util.Scanner;

/**
 * 题目：数字圆环
 *
 * 思路：
 * 首先对数组进行排序，除了最后一个数字，都满足相邻两个数字大于自己
 * 对于最后一个数字，交换最后两个数字，判断是否满足条件即可。
 *
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            boolean flag = process(arr);
            if (flag == true) {
                if (t == 0) {
                    System.out.print("YES");
                } else {
                    System.out.println("YES");
                }
            } else {
                if (t == 0) {
                    System.out.print("NO");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static boolean process(int arr[]) {
        int n = arr.length;
        if (n == 0) return false;
        if (n == 1) return true;
        for (int i = 0; i < n; i++) {
            int left, right;
            if (i == 0) {
                left = arr[n - 1];
                right = arr[i + 1];
            } else if (i >= n -1) {
                left = arr[i - 1];
                right = arr[0];
            } else {
                left = arr[i - 1];
                right = arr[i + 1];
            }
            if (arr[i] > left + right) {
                return false;
            }
        }
        return true;
    }
}
