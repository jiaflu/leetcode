package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 *
 * 解答：
 * - 中序遍历
 */

public class $938_Range_Sum_of_BST {
    static int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        search(root, L, R);
        return sum;
    }
    public void search(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        search(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        search(root.right, L, R);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
