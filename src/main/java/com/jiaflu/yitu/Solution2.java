package com.jiaflu.yitu;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        int[] signal = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
            signal[i] = in.nextInt();
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            if (dq.isEmpty() || height[i] <= height[dq.peekLast()]) {
                dq.addLast(i);
            } else {
                while (!dq.isEmpty() && height[i] > height[dq.peekLast()]) {
                    sum[i] += signal[dq.pollLast()];
                }
                dq.addLast(i);
            }
        }
        dq = new ArrayDeque<>(n);
        for (int i = n-1; i >= 0; i--) {
            if (dq.isEmpty() || height[i] <= height[dq.peekLast()]) {
                dq.addLast(i);
            } else {
                while (!dq.isEmpty() && height[i] > height[dq.peekLast()]) {
                    sum[i] += signal[dq.pollLast()];
                }
                dq.addLast(i);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
