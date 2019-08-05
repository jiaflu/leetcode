package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 解答：
 * - 二分查找的变种
 * 增倍除数
 * 比如:
 *
 * 被除数 除数
 * 15 3
 * 12 6
 * 6 12
 *
 * 发现除数**大于**被除数大,再重现开始
 * 6 3
 * ...
 * 3 3
 *
 * 虽然这个例子遍历次数相等,对于较大的数,可以减少时间复杂度.
 */

public class $29_Divide_Two_Integers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 0) return -1;

        /** -2147483648, -1 这个测试样例的确没想到，结果翻车了*/
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;

        boolean negative;
        negative = (dividend ^ divisor) < 0; // 用异或来计算是否符号相异

        /** 因为值溢出之后边界问题处理太繁琐了，直接将数值转为long省去麻烦 */
        long dividend_tmp = Math.abs((long) dividend);
        long divisor_tmp = Math.abs((long) divisor);
        int res = 0, cnt = 1;

        while (dividend_tmp >= divisor_tmp) {
            dividend_tmp -= divisor_tmp;
            res += cnt;

            divisor_tmp += divisor_tmp;
            cnt += cnt;

            if (dividend_tmp < divisor_tmp) {
                // 初始化，重新开始
                cnt = 1;
                divisor_tmp = Math.abs((long) divisor);
            }
        }
        return negative ? -res : res; // 符号相异取反
    }

}
