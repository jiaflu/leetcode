package com.jiaflu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：完全二叉树的节点个数
 */
public class $222_CountCompleteTreeNodes {

    int count = 0;
    public int countNodes(TreeNode root) {
        search(root);
        return count;
    }
    private void search(TreeNode root) {
        if (root == null) return;
        count++;
        search(root.left);
        search(root.right);
    }

    /**
     * 判断一棵二叉树是否是完全二叉树
     */
    public boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode left = null, right = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            // 如果当前节点有右孩子,但没有左孩子,直接返回 false
            // 如果当前节点并不是左右孩子全有,那之后的节点必须都为叶子节点,否则返回 false
            if ((left==null && right!=null) || (leaf && (left!=null || right!=null))) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                // 记录什么时候开始为叶子节点
                leaf = true;
            }
        }
        return true;
    }
}
