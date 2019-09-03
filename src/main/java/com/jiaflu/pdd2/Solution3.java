package com.jiaflu.pdd2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * n个骰子，第i个骰子出现的点数为1~Xi，每个点数几率相等，投n个骰子，将n个骰子中点数最大的值作为本次结果，求结果的数学期望。
 * 示例：n=2，x1=2，x2=2
 * 数学期望 = 1x1/4 + 2x3/4 = 1.75
 * 求所有骰子的结果的最大值的期望
 *
 */

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int sum = 1;
        Double result = 0.0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum *= arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        double[] res = new double[max + 1];
        for (int i = 1; i <= max; i++) {
            res[i] = 1.0;
        }

        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] < i) {
                    continue;
                }
                // 算出最大值不大于 i 的概率
                res[i] = res[i] * (1.0 * i / arr[j]);
            }
        }
        for (int i = 1; i <= max; i++) {
            // 最大值不大于 i 的概率 - 最大值不大于 i-1 的概率 = 最大值为 i 的概率
            result += (res[i] - res[i-1]) * i;
        }
        //System.out.println(String.format("0.00", res));
        System.out.printf("%.2f", result);

    }
}

/**
 * 1~N遍历，算出每一个数的概率值，
 * 比如说算最大值为3的概率的时候，
 * 先算每一个骰子取1~3的概率，乘起来，
 * 然后减去之前算的最大值为1的概率和最大值为2的概率
 */
