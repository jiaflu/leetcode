package com.jiaflu.leetcode.stack;


import java.util.*;

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Boolean> res = new ArrayList<>();
        int n = Integer.valueOf(in.nextLine());
        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            res.add(isValid(input));
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isValid(String s) {
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
