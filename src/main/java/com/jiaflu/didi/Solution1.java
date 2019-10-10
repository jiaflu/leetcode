package com.jiaflu.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：
 * 给出一个仅包含加减乘除四种运算符的算式(不含括号)，如1+2*3/4，
 * 在保持运算符顺序不变的情况下，现在你可以进行若干次如下操作：如果交换相邻的两个数，表达式值不变，那么你就可以交换这两个数。
 *
 * 现在你可以进行任意次操作，使得算式的数字序列字典序最小，然后输出结果，数字之间的字典序定义为若a<b则a的字典序小于b。
 * 样例输入：
 * 6
 * 3 + 2 + 1 + -4 * -5 + 1
 * 样例输出：
 * 1 + 2 + 3 + -5 * -4 + 1
 *
 * 解答：
 *
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String input = in.nextLine();
        String[] strs = input.split(" ");
        String[] operators = new String[n];
        int[] nums = new int[n];
        operators[0] = "+";

        int a = 0, b = 1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if ("+".equals(str) || "-".equals(str)
                || "*".equals(str) || "/".equals(str)) {
                operators[b] = str;
                b++;
            } else if (!str.isEmpty()) {
                nums[a] = Integer.valueOf(str);
                a++;
            }
        }


        int l = 1, r = 1;
        while (r < n) {
            while (r < n && operators[r].equals(operators[l])) {
                r++;
            }
            r--;
            if ("+".equals(operators[l]) || "-".equals(operators[l])) {
                if (r < n-1 && ("*".equals(operators[r+1]) || "/".equals(operators[r+1]))) {
                    //当 +或- 遇到 *或/ 的时候 r 位置的数不排序
                    Arrays.sort(nums, l-1, r);
                } else {
                    Arrays.sort(nums, l-1, r+1);
                }
            } else if ("*".equals(operators[l])) {
                if ("/".equals(operators[l-1])) {
                    // 当前一个为 / 的时候 l-1 位置的数不排序
                    Arrays.sort(nums, l, r+1);
                } else {
                    Arrays.sort(nums, l-1, r+1);
                }
            } else if ("/".equals(operators[l])) {
                if ("*".equals(operators[l-1])) {
                    // 当前一个为 * 的时候 l-1 位置的数不排序
                    Arrays.sort(nums, l, r+1);
                } else {
                    Arrays.sort(nums, l-1, r+1);
                }
            }
            r++;
            l = r;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < n; i++) {
            sb.append(" ");
            sb.append(operators[i]);
            sb.append(" ");
            sb.append(nums[i]);
        }


        System.out.println(sb.toString());

    }

}
