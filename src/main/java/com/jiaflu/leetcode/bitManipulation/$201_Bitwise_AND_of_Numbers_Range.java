package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 *
 * 解答：(思路很重要)
 * - 在数字加1的时候，最低位肯定会从0变成1，或者从1变成0，不管哪样，两个数的最低位中势必有一个0，
 * - 而一旦出现了一个0，这一位上的按位与结果将永远为0．
 * - 假如在m->n的增加过程中，m的最高位也发生了改变，那么m之下的所有位都变成过0
 */

public class $201_Bitwise_AND_of_Numbers_Range {
    public static int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            offset++;
            m = m >> 1;
            n = n >> 1;
        }
        return m << offset;
    }

    public static void main(String[] args) {
        rangeBitwiseAnd(5, 7);
    }
}
