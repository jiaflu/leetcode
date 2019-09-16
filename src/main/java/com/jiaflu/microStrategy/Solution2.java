package com.jiaflu.microStrategy;

import java.util.*;

public class Solution2 {

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

    static List<String> breace(List<String> values) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (isValid(values.get(i)) == true) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        for (int i = 0; i < n; i++) {
            values.add(in.nextLine());
        }
        List<String> res = breace(values);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        //System.out.println(breace(values));
    }

}
