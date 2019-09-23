package com.jiaflu.leetcode;

/**
 * 题目：实现 strStr()
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 解答：
 *
 */

public class $28_Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack == null || needle == null || haystack.isEmpty()
            || needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = i+1, j = 1;
                for (;index < haystack.length() && j < needle.length();) {
                    if (haystack.charAt(index) == needle.charAt(j)) {
                        j++;
                        index++;
                    } else {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
        //return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        strStr("mississippi", "issipi");
    }
}
