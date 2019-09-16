package com.jiaflu.leetcode.math;

import java.util.List;

/**
 * 题目：计数质数
 *
 * 解答：
 * - 厄拉多塞筛法
 *   - 声明一个长度为最大限制数的布尔数组,用布尔值来区别筛选出的数和质数
 *   - 过程如下：
 *      - 选中 2,排除 2 的倍数
 *      - 选中 3,排除 3 的倍数
 */


public class $204_Count_Primes {

    public static int countPrimes_(int n) {
        int cnt = 0;
        // 声明一个长度为最大限制数的布尔数组
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                cnt++;
                for (int j = 2*i; j < n; j += i) {
                    // 排除不是质数的数
                    signs[j] = true;
                }
            }
        }
        return cnt;
    }


    // 超时
    public static int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isPrimes(int num) {
        for (int i = 2; i <= num/2; i++) { // 优化
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
