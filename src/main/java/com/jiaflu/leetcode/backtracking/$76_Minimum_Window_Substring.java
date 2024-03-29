package com.jiaflu.leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 解答：
 * - 滑动窗口 + 计数索引
 * - 再做一次
 */

public class $76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // 保存 t 中所有唯一字符计数的字典
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        // t 中的唯一字符数,需要出现在所需的窗口中
        int required = dictT.size();
        // 左 右 指针
        int l = 0, r = 0;
        /**
         * formed 用于跟踪当前窗口中以其所需频率存在多少个唯一字符
         * 例如 如果 t 是 "AABC" 那么窗口必须有　２个Ａ,１个Ｂ和１个Ｃ
         * 因此,当满足所有这些条件时, formed=3
         */
        int formed = 0;
        // 字典,用于保存当前窗口中所有唯一字符的计数
        Map<Character, Integer> windowsCounts = new HashMap<>();
        // (窗口长度,左指针,右指针)
        int[] ans = {-1,0,0};
        while (r < s.length()) {
            // 从右侧向窗口添加一个字符
            char c = s.charAt(r);
            int count = windowsCounts.getOrDefault(c, 0);
            windowsCounts.put(c, count + 1);
            // 如果添加的当前字符的频率等于 t 中的所需计数，则将 formed 增加 1
            if (dictT.containsKey(c) && windowsCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            // 尝试并收缩窗口,直到它不再是 "理想的"
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // 更新满足条件的最小的窗口和 l r 指针
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // left 指针指向的位置处的字符不再是窗口的一部分
                windowsCounts.put(c, windowsCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowsCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                // 将左指针向前移动,这将有助于查找新窗口
                l++;
            }
            // 继续扩大窗口
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
