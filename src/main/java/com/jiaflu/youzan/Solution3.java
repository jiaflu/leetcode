package com.jiaflu.youzan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
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
        Arrays.sort(arr);

        int i = 0, j = arr.length - 1, res = 0;
        while (i < j) {
            res += (arr[j--] - arr[i++]) / 2;
        }
        System.out.println(res);
    }
}
