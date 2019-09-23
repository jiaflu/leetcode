package com.jiaflu.tx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int index = 0;
        for (int i = 0; i < t; i++) {
            int cnt = in.nextInt();
            int a = in.nextInt();
            for (int j = 0; j < cnt; j++) {
                sum += a;
                list.add(a);
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(partition(nums, sum));
    }

    public static int partition(int[] nums, int sum) {
        int n = nums.length;
        int mid = sum / 2;
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
        return Math.max(a,b);
    }

}
