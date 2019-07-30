package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

/**
 * 题目：
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 解答：
 * 时间复杂度较高（有空优化）
 */

public class $23_MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (true) {
            ListNode tmp = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && tmp.val > lists[i].val) {
                    tmp = lists[i];
                    index = i;
                }
            }
            if (index != -1) {
                node.next = tmp;
                node = node.next;
                lists[index] = lists[index].next;
            } else {
                break;
            }
        }
        return head.next;
    }
}
