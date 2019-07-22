package com.jiaflu.leetcode;


/**
 * 题目：判断是否为搜索二叉树
 * 解答：判断一棵二叉树是否是搜索二叉树，只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可。
 */

public class $98_ValidateBinarySearchTree {
    private boolean flag = true;
    private Long previous = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        search(root);
        return flag;
    }

    private void search(TreeNode root) {
        if (root == null || flag == false) {
            return;
        }
        search(root.left);
        if (root.val <= previous) {
            flag = false;
            return;
        } else {
            previous = Long.valueOf(root.val);
        }
        search(root.right);
    }
}
