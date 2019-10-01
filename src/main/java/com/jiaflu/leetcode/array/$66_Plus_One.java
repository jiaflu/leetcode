package com.jiaflu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：加一
 *
 * 解答：
 * - 考虑进位问题
 */

public class $66_Plus_One {
    public int[] plusOne(int[] digits) {
        int add = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] + add == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] arr = new int[digits.length+1];
                    arr[0] = 1;
                    for (int j = 1; j <= digits.length; j++) {
                        arr[j] = digits[j-1];
                    }
                    return arr;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
