package com.jiaflu.leetcode.String;

/**
 * 题目：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 解答：
 * - 中心扩展法
 * 注意两种情况：
 * （1）：回文字串为奇数的情况，如 "aba"
 * （2）：回文子串为偶数的情况，如 "abba"
 */

public class $5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 回文字串为奇数的情况，如 "aba"
            int len2 = expandAroundCenter(s, i, i + 1); // 回文子串为偶数的情况，如 "abba"
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
