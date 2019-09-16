package com.jiaflu.xiaomi;

import java.util.Scanner;

public class Solution3 {
    public static void print(String s, int left, int right) {
        if (left > right) {
            return;
        }
        // 相等表示只有一个数字，没有子树，直接输出就好。
        if (left == right) {
            System.out.print(s.charAt(left));
            return;
        }
        // 如果有子树，其实就是找到合适的左子树右子树分割点，也就是逗号的位置
        // 当前为逗号时，且左右括号数相等的时候，就是原来子树中左右分割点
        int countP = 0;
        // +2的原因在于，跳过root值和第一个'('
        int it = left + 2;
        while (countP != 0 || s.charAt(it) != ',') {
            if (s.charAt(it) == '(') {
                countP++;
            } else if (s.charAt(it) == ')') {
                countP--;
            }
            it++;
        }
        print(s, left + 2, it - 1);
        System.out.print(s.charAt(left));
        print(s, it + 1, right - 1);
    }
}
