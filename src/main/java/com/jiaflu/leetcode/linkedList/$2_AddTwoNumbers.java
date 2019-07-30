package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 * 给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class $2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + temp;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + temp;
                l2 = l2.next;
            } else {
                sum = l1.val + temp;
                l1 = l1.next;
            }
            temp = sum / 10;
            list.add(sum % 10);
        }
        if (temp != 0) {
            list.add(temp);
        }

        ListNode head = new ListNode(-1);
        ListNode ret = head;
        for (int i = 0; i < list.size(); i ++) {
            ListNode node = new ListNode(list.get(i));
            head.next = node;
            head = head.next;
        }
        return ret.next;
    }
}
