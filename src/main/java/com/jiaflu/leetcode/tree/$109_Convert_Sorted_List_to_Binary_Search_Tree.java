package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.ListNode;
import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：有序链表转换二叉搜索树
 *
 * 解答:
 * - 链表转数组
 * - 中间元素 (left+right)/2 作为根
 * - 递归构造二叉搜索树的左右两颗子树，(left, mid-1) 和 (mid+1, right)
 */

public class $109_Convert_Sorted_List_to_Binary_Search_Tree {
    private List<Integer> values;

    public TreeNode sortedListToBST(ListNode head) {
        values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return convertListToBST(0, values.size()-1);
    }

    private TreeNode convertListToBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        if (left == right) {
            return node;
        }
        node.left = convertListToBST(left, mid -1);
        node.right = convertListToBST(mid+1, right);
        return node;
    }
}
