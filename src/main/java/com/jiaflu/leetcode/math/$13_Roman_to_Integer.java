package com.jiaflu.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：罗马数字转整数
 * 字符          数值
 *  I             1
 *  V             5
 *  X             10
 *  L             50
 *  C             100
 *  D             500
 *  M             1000
 * 解答：
 * - 首先建立一个HashMap来映射符号和值，
 * - 然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。
 * - 以此类推到，最后加上最后一个字符代表的值
 *
 *
 */

public class $13_Roman_to_Integer {
    Map<Character, Integer> map = new HashMap<>();
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int left = map.get(s.charAt(i));
            int right = map.get(s.charAt(i+1));
            if (left >= right) {
                sum += left;
            } else {
                sum -= left;
            }
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
