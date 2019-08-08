package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 解答：
 * - 2 的 n 次方中二进制显示只有一个 1
 * - (n & (n-1)) == 0 时为 2 的 n 次方
 */
public class $231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if ((n & (n-1)) == 0) return true;
        return false;
    }

}
