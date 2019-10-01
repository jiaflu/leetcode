package com.jiaflu.leetcode;

import java.util.PriorityQueue;

/**
 * 原先指向左指针的节点调整为链表中指向前一个的节点；
 * 原先指向右指针的节点调整为链表中指向后一个的节点（即 找到前一个节点拿 pre指向该节点）
 */


public class BSTToList {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        // 关键是 pre 的指向
        pre = node;
        // head 指操作了一次
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String d = new String("abc");
        String a = "abc";
        String b = a;
        String c = "abc";
        //String d = new String("abc");
        System.out.println(a == c);
    }
}
