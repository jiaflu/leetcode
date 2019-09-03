package com.jiaflu.pdd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 女朋友和男朋友玩纸牌，各抽 n1 n2 张牌，
 * 女朋友有三种策略：d：丢弃牌堆中最左边的牌、l：将牌堆中最左边的牌放到新牌堆最左边、r：将牌堆中最左边的牌放到新牌堆最右边。
 * 求能使女朋友和男朋友纸牌顺序及顺序相同的策略。
 * 示例：女朋友抽到三张牌，分别为：1 2 3，男朋友抽到一张牌，为：3
 * 则策略为：d d l 或者 d d r
 *
 * 思路：
 * - dfs
 */

public class Solution2 {
    static int len;
    static List<String> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        while (s-- > 0) {
            String s1 = in.next();
            String s2 = in.next();
            list = new ArrayList<>();
            len = s1.length();
            dfs(s1, s2, "", "", 0);
            System.out.println("{");
            for (int i = 0; i < list.size(); i++) {
                String temp = list.get(i);
                for (int k = 0; k < temp.length(); k++) {
                    if (k == 0) {
                        System.out.print(temp.charAt(k));
                    } else {
                        System.out.print(" " + temp.charAt(k));
                    }
                }
                System.out.println();
            }
            System.out.println("}");
        }
    }

    private static void dfs(String s1, String s2, String res, String e, int index) {
        if (index == len) {
            if (res.equals((s2))) {
                list.add(e);
            }
            return;
        }
        dfs(s1, s2, res, e + "d", index+1);
        dfs(s1, s2, s1.charAt(index) + res, e + "l", index+1);
        dfs(s1, s2, res + s1.charAt(index), e + "r", index+1);
    }


}
