package com.jiaflu.leetcode.binarySearch;

/**
 * 题目： Sqrt(x)
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 解答：
 * - 二分法查找
 *
 */

public class $69_Sqrt_x {

    public static int mySqrt(int x) {
        if (x == 1) return 1;
        long left = 0;
        long right = (long) x/2;
        long mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (mid * mid > x) {
            return (int) (mid - 1);
        }
        return (int) mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
}
