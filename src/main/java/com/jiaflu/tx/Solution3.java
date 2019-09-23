package com.jiaflu.tx;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                sum += temp;
                arr[j] = temp;
            }
            res.add(partition(arr, sum));
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0) + " " + res.get(i).get(1));
        }
    }

    public static List<Integer> partition(int[] nums, int sum) {
        int n = nums.length;
        int mid = sum / 2;
        // 01 背包问题
        int[][] dp = new int[nums.length+1][mid + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= mid; j++) {
                if (nums[i] > j) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-nums[i]] + nums[i]);
                }
            }
        }
        int a = dp[nums.length][mid];
        int b = sum - dp[nums.length][mid];
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Collections.sort(list);
        return list;
    }
}
