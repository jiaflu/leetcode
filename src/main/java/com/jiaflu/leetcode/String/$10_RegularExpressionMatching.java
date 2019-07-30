package com.jiaflu.leetcode.String;

/**
 * 题目：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 *  解答：
 *  回溯
 *
 * - 如果没有星号（*），问题很简单，我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符即可
 * - 如果模式有星号（*），它会出现在第二个位置，即`p[1]`
 *   - 若 `s[0] == p[0]`，则可以删除匹配串的这个字符
 *   - 若 `s[0] != p[0]`，则可以忽略模式串的这一部分
 */

public class $10_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

}
