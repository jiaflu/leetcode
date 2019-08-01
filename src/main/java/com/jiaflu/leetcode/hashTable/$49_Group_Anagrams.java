package com.jiaflu.leetcode.hashTable;

import java.util.*;

/**
 * 题目：字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 解答：
 * - String 字符重排序
 * - map 遍历
 *
 */

public class $49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // String 字母重排序
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmp = String.valueOf(chars);
            if (map.get(tmp) != null) {
                List<String> list = map.get(tmp);
                list.add(strs[i]);
                map.put(tmp, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(tmp, list);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (String str : map.keySet()) {
            lists.add(map.get(str));
        }
        return lists;
    }
}
