package com.jiaflu.leetcode.bitManipulation;


/**
 * 题目:位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 解答：
 * - 参考 190,190 会了这个 easy
 */

public class $191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = n >> i;
            if ((tmp & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}
