package com.jiaflu.leetcode.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 题目：括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 *
 * 解答：
 * - 递归（回溯）
 *
 */

public class $22_GenerateParentheses {

    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return list;
    }

    private void generate(String str, int a, int b) {
        if (a == 0 && b == 0) {
            list.add(str);
            return;
        }
        if (a > 0) {
            if (a < b) {
                generate(str + "(", a-1, b);
                generate(str + ")", a, b-1);
            } else if (a == b) {
                generate(str + "(", a-1, b);
            }
        }
        if (a == 0) {
            generate(str + ")", a, b-1);
        }
    }

    public static void func(int n) {
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10;
        func(n = n - 1);
    }
}
