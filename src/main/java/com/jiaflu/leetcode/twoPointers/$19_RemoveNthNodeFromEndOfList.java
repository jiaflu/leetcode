package com.jiaflu.leetcode.twoPointers;

import com.jiaflu.leetcode.ListNode;

/**
 * 题目：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 解答：
 * - 双指针
 */

public class $19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode end = start;
        head = start;
        // end 先移动 n
        while (n > 0) {
            end = end.next;
            n--;
        }
        // start、end 一起移动, end.next 为 null 时 start 为倒数第 n 个节点的前一个节点
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head.next;
    }
}
