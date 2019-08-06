package com.jiaflu.leetcode.stack;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 题目：逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * 解答：
 * - Stack
 *
 */


public class $150_Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() >= 2 || (tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9')) {
                stack.add(Integer.valueOf(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if ("+".equals(tokens[i])) {
                    res = a + b;
                } else if ("-".equals(tokens[i])) {
                    res = b - a;
                } else if ("/".equals(tokens[i])) {
                    res = b / a;
                } else if ("*".equals(tokens[i])) {
                    res = a * b;
                }
                stack.add(res);
            }
        }
        if (!stack.isEmpty()){
            res = stack.pop();
        }
        return res;
    }

    // 这个判断方法大大降低了算法效率
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(strs));

    }
}
