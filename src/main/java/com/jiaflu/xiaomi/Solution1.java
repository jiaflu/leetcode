package com.jiaflu.xiaomi;

import com.jiaflu.leetcode.TreeNode;

import java.util.Scanner;

public class Solution1 {
    static StringBuilder builder = new StringBuilder();
    static String solution(String input) {
        builder = new StringBuilder();
        TreeNode root = buileTree(input);
        search(root);
        return builder.toString();
    }

    static TreeNode buileTree(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        int val = 0, index = 0;
        for (index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '(') {
                val = Integer.valueOf(input.substring(0, index));
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        String substr = input.substring(index+1, input.length());
        int cnt = 1;
        for (index = 1; index < substr.length(); index++) {
            if (substr.charAt(index) == '(') {
                cnt++;
            }
            if (substr.charAt(index) == ')') {
                cnt--;
            }
            if (substr.charAt(index) == ',' && cnt == 0) {
                break;
            }
        }
        root.left = buileTree(substr.substring(0, index+1));
        root.right = buileTree(substr.substring(index+1, substr.length()));
        return root;
    }

    static void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        builder.append(root.val);
        search(root.right);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
