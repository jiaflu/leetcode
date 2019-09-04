package com.jiaflu.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目：基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 解答：
 * - Stack
 * - 代码写得又垃圾又丑。。。
 */

public class $227_Basic_Calculator_II {
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sum = sum * 10 + s.charAt(i) - '0';
            } else {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                list.add(String.valueOf(sum));
                sum = 0;
                list.add(String.valueOf(s.charAt(i)));
            }
        }
        list.add(String.valueOf(sum));

        for (int i = 0; i < list.size(); i++) {
            if (!"*".equals(list.get(i)) && !"/".equals(list.get(i))) {
                stack.push(list.get(i));
            } else {
                long a = Integer.valueOf(stack.pop());
                long b = Integer.valueOf(list.get(i+1));
                long tmp = 0;
                if ("*".equals(list.get(i))) {
                    tmp = a * b;
                } else {
                    tmp = a / b;
                }
                i++;
                stack.push(String.valueOf(tmp));
            }
        }
        Stack<String> help = new Stack<>();
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        while (!help.isEmpty() && help.size() >= 3) {
            long a = Integer.valueOf(help.pop());
            String c = help.pop();
            long b = Integer.valueOf(help.pop());
            long tmp = 0;
            if ("+".equals(c)) {
                tmp = a + b;
            } else {
                tmp = a - b;
            }
            help.push(String.valueOf(tmp));
        }
        return Integer.valueOf(help.pop());
    }

    public static void main(String[] args) {
        String s = "1-1+1";
        System.out.println(calculate(s));
    }
}
