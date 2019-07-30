package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

/**
 * 题目：
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 解答：
 *
 */

public class $21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head, node;
        if (l1.val <= l2.val) {
            head = l1;
            node = l1;
            l1 = l1.next;
        } else {
            head = l2;
            node = l2;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            } else if (l1 != null && l2 == null) {
                node.next = l1;
                break;
            } else if (l1 == null && l2 != null){
                node.next = l2;
                break;
            }
        }
        return head;
    }

}
