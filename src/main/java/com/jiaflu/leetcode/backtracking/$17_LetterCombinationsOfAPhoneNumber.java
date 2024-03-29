package com.jiaflu.leetcode.backtracking;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 解答：
 * - 递归求解
 * - 注意一些场景的应对策略
 */

public class $17_LetterCombinationsOfAPhoneNumber {

    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    private void backtrace(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            list.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(digit).substring(i, i+1);
                backtrace(combination + letter, next_digits.substring(1));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrace("", digits);
        }
        return list;
    }

}
