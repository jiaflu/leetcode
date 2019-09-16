package com.jiaflu.microStrategy;

import com.jiaflu.leetcode.TreeNode;
import com.jiaflu.leetcode.tree.Tree;

public class Solution1 {
    private static int isPresent(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.val == val) {
            return 1;
        }
        if (root.val > val && root.left != null) {
            return isPresent(root.left, val);
        }
        if (root.val < val && root.right != null) {
            return isPresent(root.right, val);
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        System.out.println(isPresent(root, 15));
    }

//    private static int isPresent(Node root, int val) {
//        if (root == null) {
//            return 0;
//        }L
//        if (root.data == val) {
//            return 1;
//        }
//        if (root.data > val && root.left != null) {
//            return isPresent(root.left, val);
//        }
//        if (root.data < val && root.right != null) {
//            return isPresent(root.right, val);
//        }
//        return 0;
//    }
}
