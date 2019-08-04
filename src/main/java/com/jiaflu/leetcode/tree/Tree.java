package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.*;

public class Tree {

    /**
     * 递归方式遍历二叉树
     */

    // 先序
    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序
    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    // 后序
    public void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 非递归方式遍历二叉树
     */

    // 先序
    /**
     * - 申请一个新的栈，记为 `stack`。然后将头节点 `head` 压入 `stack` 中。
     * - 从 `stack` 中弹出栈顶节点，记为 `cur`，然后打印 `cur` 节点的值，再将节点 `cur` 的右孩子（不为空的话）先压入 `stack` 中==，==最后将 `cur` 的左孩子（不为空的话）压入 `stack` 中。
     * - 不断重复步骤 2，直到 `stack` 为空，全部过程结束。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    // 中序
    /**
     * - 申请一个新的栈，记为 `stack`。初始时，令变量 `cur=head`。
     * - 先把 `cur` 节点压入栈中，对以 `cur` 节点为头的整棵子树来说，依次把左边界压入栈中，即不停地令 `cur=cur.left`，然后重复步骤 2。
     * - 不断重复步骤 2，直到发现 `cur` 为空，此时从 `stack` 弹出一个节点，记为 `node`。打印 `node` 的值，并且让 `cur=node.right`。然后继续重复步骤 2。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>(); // 用于判断是否已经访问过
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && !set.contains(cur.left)) {
                stack.push(cur.left);
            } else {
                cur = stack.pop();
                list.add(cur.val);
                set.add(cur);
                if (cur.right != null) {
                    stack.add(cur.right);
                }
            }
        }
        return list;
    }

    // 后序
    /**
     * - stack 辅助
     * - set 判断是否被访问过
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>(); // 用于判断是否已经访问过
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && !set.contains(cur.left)) {
                stack.push(cur.left);
            } else {
                if (cur.right != null && !set.contains(cur.right)) {
                    stack.push(cur.right);
                } else {
                    cur = stack.pop();
                    list.add(cur.val);
                    set.add(cur);
                }
            }
        }
        return list;
    }


}
