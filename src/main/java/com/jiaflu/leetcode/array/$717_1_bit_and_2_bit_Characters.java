package com.jiaflu.leetcode.array;

/**
 * 题目：1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 解答：
 * - 对 bits 数组从左到右扫描来判断最后一位是否为一比特字符。
 * - 当扫描到第 i 位时，如果 bits[i]=1，那么说明这是一个两比特字符，将 i 的值增加 2。
 * - 如果 bits[i]=0，那么说明这是一个一比特字符，将 i 的值增加 1。
 * - 如果 i 最终落在了 bits.length−1 的位置，那么说明最后一位一定是一比特字符。
 *
 */

public class $717_1_bit_and_2_bit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length-1) {
            if (bits[i] == 0) {
                i++;
            } else if (bits[i] == 1) {
                i += 2;
            }
        }
        return i == bits.length-1;
    }
}
