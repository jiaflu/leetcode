package com.jiaflu.leetcode;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            boolean flag = process(strs);
            System.out.println(flag);

            break;
        }
    }

    private static boolean process(String[] strs) {
        if (strs == null || strs.length == 0) return false;
        char head = strs[0].charAt(0);
        char end = strs[0].charAt(strs[0].length()-1);
        for (int i = 1; i < strs.length; i++) {
            char secondHead = strs[i].charAt(0);
            if (secondHead == end) {
                end = strs[i].charAt(strs[i].length()-1);
                continue;
            } else {
                return false;
            }
        }
        if (head == end) {
            return true;
        } else {
            return false;
        }
    }

}
