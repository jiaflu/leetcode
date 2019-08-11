package com.jiaflu.pdd;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        // 初始化步骤
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        process(arr);

    }

    public static  void process(int[] arr) {
        if (arr == null || arr.length < 3) {
            System.out.println("");
        }

        Arrays.sort(arr);
        double min = Double.MAX_EXPONENT;
        for (int i = 1; i < arr.length-1; i++) {
            double a = arr[i-1];
            double b = arr[i];
            double c = arr[i+1];
            double average = (a + b + c) / 3;
            double tmp = (Math.pow((a-average), 2) + Math.pow((b-average), 2) + Math.pow((c-average), 2)) / 3;
            if (min > tmp) {
                min = tmp;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(min));
    }

}
