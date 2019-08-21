package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 解答：
 * - 第一次中序遍历记录总合
 * - 第二次中序遍历：root.val = root.val + cnt1 - cnt2;
 */

public class $538_Convert_BST_to_Greater_Tree {
    static int cnt1, cnt2;
    public TreeNode convertBST(TreeNode root) {
        cnt1 = 0;
        cnt2 = 0;
        search1(root);
        search2(root);
        return root;
    }

    private static void search1(TreeNode root) {
        if (root == null) return;
        search1(root.left);
        cnt1 += root.val;
        search1(root.right);
    }
    private static void search2(TreeNode root) {
        if (root == null) return;
        search2(root.left);
        cnt2 += root.val;
        root.val = root.val + cnt1 - cnt2;
        search2(root.right);
    }

}
