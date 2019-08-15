package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 解答：
 * - easy
 */

public class $693_Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n = n >> 1;
        while (n != 0) {
            int tmp = n & 1;
            if (pre != tmp) {
                pre = tmp;
                n = n >> 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
