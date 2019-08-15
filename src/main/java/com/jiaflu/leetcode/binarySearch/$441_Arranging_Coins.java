package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * 解答：
 * - 高斯公式
 * - long
 * - 二分查找
 *
 */

public class $441_Arranging_Coins {
    public int arrangeCoins(int n) {
        long left = 1, right = n;
        long mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long count = (1 + mid) * mid / 2;
            if (count > n) {
                right = mid - 1;
            } else if (count < n) {
                left = mid + 1;
            } else {
                break;
                //return mid;
            }
        }
        long count = (1 + mid) * mid / 2;
        if (count > n) {
            return (int)(mid - 1);
        }
        return (int)mid;
    }
}
