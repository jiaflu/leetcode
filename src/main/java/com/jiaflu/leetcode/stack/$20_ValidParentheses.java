package com.jiaflu.leetcode.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * - 左括号必须用相同类型的右括号闭合。
 * - 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 解答：
 * - 栈
 * - HashMap 用于判断括号是否匹配
 */

public class $20_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character tmp = stack.peek();
                if (map.get(tmp) == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
