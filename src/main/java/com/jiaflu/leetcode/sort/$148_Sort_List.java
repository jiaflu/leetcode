package com.jiaflu.leetcode.sort;

import com.jiaflu.leetcode.ListNode;

/**
 * 题目：排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 解答：
 * - 链表的归并或快排
 */

public class $148_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode[] counter = new ListNode[64];
        ListNode curNode = head;
        int maxIndex = 0;
        while (curNode != null) {
            ListNode carryNode = curNode;
            curNode = curNode.next;
            carryNode.next = null;
            int i = 0;
            while (counter[i] != null) {
                ListNode newMergeNode = merge(carryNode, counter[i]);
                counter[i] = null;
                i++;
                carryNode = newMergeNode;
            }
            counter[i] = carryNode;
            if (i > maxIndex){
                maxIndex = i;
            }
        }
        ListNode res = null;
        for (int i = 0; i <= maxIndex; i++) {
            if (counter[i] != null) {
                res = merge(res, counter[i]);
            }
        }
        return res;
    }

    ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if (n1.val < n2.val) {
            n1.next = merge(n1.next, n2);
            return n1;
        } else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }
}
