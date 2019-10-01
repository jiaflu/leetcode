package com.jiaflu.leetcode.math;

/**
 * 题目：字符串转换整数 (atoi)
 *
 * 解答：
 * - 一次构建反转整数的一位数字
 * - 在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
 * - 2^31-1=2147483647,-2^31=-2147483648
 */

public class $8_String_to_Integer_atoi {
    public int myAtoi(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        for (int k = 0; k < num.length(); k++) {
            int cur = num.charAt(k) - '0';
            if (negative) {
                if (ret < Integer.MIN_VALUE/10 || ret == Integer.MIN_VALUE/10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE/10 || ret == Integer.MAX_VALUE/10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(-Math.pow(2,31));
        System.out.println(Math.pow(2,31)-1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
