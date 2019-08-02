package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 解答：
 * - 层次遍历，使用 `queue`
 * - 需要记录每一层的个数
 */

public class $102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.add(root);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int tmp = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    tmp++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    tmp++;
                }
            }
            lists.add(list);
            cnt = tmp;
        }
        return lists;
    }
}
