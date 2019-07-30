package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：
 * 删除二叉搜索树中的节点
 *
 * 解答：
 * - BST 搜索
 * - 找到 `key` 删除时
 *   - 左子树为空则返回右子树作为新的根
 *   - 右子树为空则返回左子树作为新的根
 *   - 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
 *     - 找到后继节点
 *     - 删除后继节点
 */

public class $450_DeleteNodeInaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    // 难点
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

}
