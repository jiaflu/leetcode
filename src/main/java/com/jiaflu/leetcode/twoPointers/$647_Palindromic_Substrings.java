package com.jiaflu.leetcode.twoPointers;

/**
 * 题目：回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 解答：
 * - 双指针
 * - 双端扩展
 */

public class $647_Palindromic_Substrings {
    int num = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i); // 回文串长度为奇数
            count(s, i,i+1); // 回文串长度为偶数
        }
        return num;
    }
    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            // 双向扩展
            start--;
            end++;
        }
    }

}
