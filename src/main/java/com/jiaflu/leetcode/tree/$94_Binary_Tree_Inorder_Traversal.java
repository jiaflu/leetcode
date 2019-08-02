package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 解答：
 * - 二叉树的中序遍历
 * - 递归
 */
public class $94_Binary_Tree_Inorder_Traversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        searchTree(root);
        return list;
    }

    private void searchTree(TreeNode root) {
        if (root == null) {
            return;
        }
        searchTree(root.left);
        list.add(root.val);
        searchTree(root.right);
    }
}
