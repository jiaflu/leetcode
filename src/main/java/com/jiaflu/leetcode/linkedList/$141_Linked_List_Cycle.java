package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 解答：
 * - Set 判断是否包含
 */
public class $141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
                head = head.next;
            }
        }
        return false;
    }

}
