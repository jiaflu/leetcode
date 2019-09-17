package com.jiaflu.kuaishou;

import java.util.*;

/**
 * 手机键盘打字组合
 *
 * leetcode 17
 */

public class Solution2 {
    static Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    static List<String> list = new ArrayList<>();
    private static void dfs(String res, String next) {
        if (next.length() == 0) {
            list.add(res);
        } else {
            String digit = next.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(digit).substring(i, i+1);
                dfs(res + letter, next.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        dfs("", input);
        System.out.println(list.toString());
    }
}
