package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 解答：
 * - 将给定的二进制数,由低到高位逐个取出
 * - 然后通过位运算将其放置到反转后的位置.
 * - 将上述结果再次通过运算结合到一起
 */

public class $190_Reverse_Bits {

    // you need treat n as an unsigned value
    public static  int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <32; i++) {
            int tmp = n >> i;
            tmp = tmp & 1; // 从低位到高位逐个取出
            tmp = tmp << 31 - i; // 反转
            res |= tmp; // 合
        }
        return res;

        // 作弊方法
        // return Integer.reverse(n);
    }


    public static void main(String[] args) {
        System.out.println(reverseBits(13));
    }
}
