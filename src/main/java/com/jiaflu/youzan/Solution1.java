package com.jiaflu.youzan;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            sum += num;
            arr[i] = num;
        }

        int a = 0, b = 0;
        a = sum / n;
        if (sum % n != 0) {
            b = a + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int t1 = Math.abs(arr[i] - a);
            int t2 = Math.abs(arr[i] - b);
            int t3 = Math.min(t1, t2);
            if (t3 > max) {
                max = t3;
            }
        }
        System.out.println(max);

    }
}
