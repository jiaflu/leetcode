package com.jiaflu.leetcode.tree;


import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：判断是否为搜索二叉树
 * 假设一个二叉搜索树具有如下特征：
 * - 节点的左子树只包含小于当前节点的数。
 * - 节点的右子树只包含大于当前节点的数。
 * - 所有左子树和右子树自身必须也是二叉搜索树
 *
 * 解答：判断一棵二叉树是否是搜索二叉树，只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可。
 */

public class $98_Validate_Binary_SearchTree {
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
