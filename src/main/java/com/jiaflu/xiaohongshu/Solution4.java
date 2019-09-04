package com.jiaflu.xiaohongshu;

import java.util.Scanner;

/**
 *
 */

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder res = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cnt == 0 && c == '<') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length()-1);
                }
            } else if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            } else {
                if (cnt == 0) {
                    res.append(c);
                }
            }
        }
        System.out.println(res.toString());
    }
}
