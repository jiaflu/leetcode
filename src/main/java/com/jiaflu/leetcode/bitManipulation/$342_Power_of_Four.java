package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 解答：
 * - 4 的幂的二进制数的特点是：只有 1 个 1,1 的右边0的个数为 0,2,3,...
 */

public class $342_Power_of_Four {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        int count = 0;
        while (num != 0) {
            int tmp = num & 1;
            num = num >> 1;
            if (tmp == 1) {
                if (count % 2 != 0 || num != 0) {
                    return false;
                }
            } else {
                count++;
            }
        }
        return true;
    }
}
