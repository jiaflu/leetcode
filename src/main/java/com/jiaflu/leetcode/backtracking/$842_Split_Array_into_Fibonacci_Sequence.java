package com.jiaflu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 解答：
 * - 回溯
 */

public class $842_Split_Array_into_Fibonacci_Sequence {
    static List<Integer> res;
    public static List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        int n = S.length();
        for (int i = 0; i < Math.min(10, n); i++) {
            int a, b1, b2;
            if (Long.valueOf(S.substring(0, i+1)) > Integer.MAX_VALUE) {
                break;
            }
            a = Integer.valueOf(S.substring(0, i+1));
            for (int j = i+2; j < Math.min(i+10, n); j++) {
                if (Long.valueOf(S.substring(i+1, j)) > Integer.MAX_VALUE) {
                    break;
                }
                b1 = Integer.valueOf(S.substring(i+1, j));
                search(S, a, b1);
                if (!res.isEmpty() && res.size() >= 3) {
                    return res;
                } else {
                    res.clear();
                }
            }
        }
        return res;
    }

    private static void search(String S, int a, int b) {
        String str = "";
        str += String.valueOf(a) + String.valueOf(b);
        res.add(a);
        res.add(b);
        while (true) {
            if (str.length() == S.length()) {
                break;
            }
            str += String.valueOf(a+b);
            if (str.length() > S.length() || !str.equals(S.substring(0, str.length()))) {
                res.clear();
                break;
            }
            int tmp = a + b;
            res.add(tmp);
            a = b;
            b = tmp;
        }
    }

    public static void main(String[] args) {
        splitIntoFibonacci("11235813");
        //String s = "abcd";
        //System.out.println(s.substring(4,4));
    }
}
