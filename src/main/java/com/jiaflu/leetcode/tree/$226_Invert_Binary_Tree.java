package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 解答：
 * - 递归
 */

public class $226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
    }
}
