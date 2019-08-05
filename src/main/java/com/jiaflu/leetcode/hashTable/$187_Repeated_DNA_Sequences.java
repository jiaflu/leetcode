package com.jiaflu.leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 *
 * 示例:
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 解答：
 * - 双 HashSet 判断
 */

public class $187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> help = new HashSet<>();
        for(int i = 0; i <= s.length()-10; i++){
            String cur = s.substring(i, i+10);
            if(!set.add(cur)) help.add(cur);
        }
        return new ArrayList<String>(help);
    }
}
