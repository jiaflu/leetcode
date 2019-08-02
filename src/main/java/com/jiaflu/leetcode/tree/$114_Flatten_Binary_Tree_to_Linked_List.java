package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 解答：
 * - 要求原地展开
 * - 在没有操作节点右子树前，不能破坏该节点的右子树，所以采用**后续遍历**
 * - 后续遍历，自底向上把子树展开为链表
 *
 */

public class $114_Flatten_Binary_Tree_to_Linked_List {


    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // 自底向上展开原则如下
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = tmp;
    }

}
