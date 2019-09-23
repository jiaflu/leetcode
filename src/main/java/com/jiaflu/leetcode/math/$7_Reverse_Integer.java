package com.jiaflu.leetcode.math;

/**
 * 题目：整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 解答：
 * - 一次构建反转整数的一位数字
 * - 在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
 * - 2^31-1=2147483647,-2^31=-2147483648
 */

public class $7_Reverse_Integer {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;

    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        if (1534236469 > Integer.MAX_VALUE/2) {
            System.out.println(true);
        }
    }
}
