package com.jiaflu.leetcode.twoPointers;


import com.jiaflu.leetcode.ListNode;

/**
 * 题目：回文链表
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 解答：
 * - 时间复杂度 O(n), 空间复杂度 O(1)
 * - 快慢指针，反转前半段链表
 *
 */

public class $234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            // 反转前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 先移动指针再反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        // 奇数个数的处理情况
        ListNode p1 = fast == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
