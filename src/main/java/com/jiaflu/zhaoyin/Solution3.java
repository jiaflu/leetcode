package com.jiaflu.zhaoyin;

import java.util.Scanner;

public class Solution3 {
    static int cnt = 0;
    public static void main(String[] args) {
        cnt = 0;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        dfs(input, 0, 0, 0);
        System.out.println(cnt%(1000000000+7));
    }

    public static void dfs(String input, int n, int index, int sum) {
        sum = sum * 10 + n;
        if (index >= input.length()) {
            if (sum % 13 == 5) {
                cnt++;
                return;
            } else {
                return;
            }
        }

        char c = input.charAt(index);
        if (c == '?') {
            for (int i = 0; i <= 9; i++) {
                dfs(input, i, index+1, sum);
            }
        } else {
            dfs(input, c-'0', index+1, sum);
        }
    }
}
