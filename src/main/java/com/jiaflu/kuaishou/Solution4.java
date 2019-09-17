package com.jiaflu.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个未排序的数组,找出其最长等差数列
 */

public class Solution4 {
    public static void main(String[] args) {
        int max = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        if (n < 2) {
            System.out.println(0);
        }
        Arrays.sort(arr);
        int[][] dp = new int[n][200001];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int step = arr[i] - arr[j] + 10000;
                if (dp[j][step] > 0) {
                    dp[i][step] = Math.max(dp[j][step] + 1, dp[i][step]);
                } else {
                    dp[i][step] = 2;
                }
                max = Math.max(max, dp[i][step]);
            }
        }
        System.out.println(max);
    }
}
