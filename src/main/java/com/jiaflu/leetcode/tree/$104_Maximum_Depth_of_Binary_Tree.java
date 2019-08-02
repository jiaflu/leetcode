package com.jiaflu.leetcode.tree;


import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点
 *
 * 解答：
 * - 递归遍历
 */
public class $104_Maximum_Depth_of_Binary_Tree {

    private int max = -1;
    public int maxDepth(TreeNode root) {
        search(root, 0);
        return max;
    }

    private void search(TreeNode root, int depth) {
        if (root == null) {
            if (depth > max) max = depth;
            return;
        }
        search(root.left, depth + 1);
        search(root.right, depth + 1);
    }

}
