package com.jiaflu.leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 *
 * 解答：
 * - HashMap
 *
 */

public class $438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || p.length() > s.length()) return res;

        int cnt = 0;
        Map<Character, Integer> mapP = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            mapP.put(c, mapP.getOrDefault(c, 0) + 1);
            cnt++;
        }

        int start = 0, end = 0;
        for(int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (mapP.containsKey(c)) {
                int temp = mapP.get(c);
                mapP.put(c, temp-1);
                cnt--;
            }
            end++;
        }
        while (end <= s.length()) {
            if (cnt == 0) {
                boolean flag = true;
                for (Character c : mapP.keySet()) {
                    if (mapP.get(c) != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    res.add(start);
                }
            }
            // 向前移动 1 个位置
            char c = s.charAt(start);
            if (mapP.containsKey(c)) {
                mapP.put(c, mapP.get(c) + 1);
                cnt++;
            }
            start++;
            if (end >= s.length()) break;
            c = s.charAt(end);
            if (mapP.containsKey(c)) {
                int temp = mapP.get(c);
                mapP.put(c, temp-1);
                cnt--;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("abacbabc", "abc");
    }
}
