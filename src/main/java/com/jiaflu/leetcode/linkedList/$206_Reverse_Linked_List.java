package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

/**
 * 题目：反转链表
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 解答：
 *
 */

public class $206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = node;
            node = tmp;
        }
        return node;
    }
}
