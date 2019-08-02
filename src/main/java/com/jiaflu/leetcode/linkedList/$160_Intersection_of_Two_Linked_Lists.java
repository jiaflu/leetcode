package com.jiaflu.leetcode.linkedList;

import com.jiaflu.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 解答：
 * - Set
 *
 */
public class $160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
