package com.jiaflu.microStrategy;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {

    }

    static List<String> braces(List<String> values) {
        List<String> res = new ArrayList<>();
        for (String str : values){
            if (isValid(str)) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }
        return res;
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
