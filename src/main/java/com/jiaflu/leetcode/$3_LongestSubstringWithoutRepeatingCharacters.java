package com.jiaflu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class $3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int head = 0, end = 1;
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        max = 1;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c1 = s.charAt(head);
            set.add(c1);
            while (end < s.length()) {
                char c2 = s.charAt(end);
                if (!set.contains(c2)) { // 未出现重复
                    set.add(c2);
                    end++;
                    if (set.size() > max) {
                        max = set.size();
                    }
                } else { // 出现重复
                    if (set.size() > max) {
                        max = set.size();
                    }
                    set.clear();
                    head = head++;
                    end = head++;
                }
            }
        }
        return max;
    }
}
