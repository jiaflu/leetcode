package com.jiaflu.pdd;

import java.util.Scanner;

public class Solution6 {

    public static void main(String[] args) {
        // 初始化
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        process(arr, l, n);
    }

    private static void process(int[] arr, int l, int n) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index += arr[i];
        }
        index = index % l;
        int left = (index - 1 + l) % l;
        int right = (index + 1 + l) % l;
        int left_count = 0, right_count = 0, count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            if (tmp == index) {
                flag = true;
                continue;
            }
            if (tmp - index <0 && Math.abs(tmp - index) <= tmp + l - index) {
                // 在 index 左边
                int cnt = left - tmp;
                count += cnt;
                left_count++;
                left = (left - 1 + l) % l;
            } else {
                // 在 index 右边
                int cnt = (tmp + l - right) % l;
                count += cnt;
                right_count++;
                right = (right + 1 + l) % l;
            }
//            if (tmp > index/2) {
//                // 在 index 左边
//                int cnt = left - tmp;
//                count += cnt;
//                left_count++;
//                left = (left - 1 + l) % l;
//            }
//            if (tmp < index/2) {
//                // 在 index 右边
//                int cnt = (tmp + l - right) % l;
//                count += cnt;
//                right_count++;
//                right = (right + 1 + l) % l;
//            }
        }
        System.out.println(count);
    }

}
