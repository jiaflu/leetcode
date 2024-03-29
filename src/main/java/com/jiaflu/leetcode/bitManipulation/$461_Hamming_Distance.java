package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 解答：
 * - 位运算
 */

public class $461_Hamming_Distance {
    public static int hammingDistance(int x, int y) {
        int cnt = 0;
        while (x > 0 || y > 0) {
            int a = x & 1;
            int b = y & 1;
            if (a != b) {
                cnt++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
