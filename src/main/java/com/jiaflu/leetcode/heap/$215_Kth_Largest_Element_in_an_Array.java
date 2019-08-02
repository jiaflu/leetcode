package com.jiaflu.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 题目：数组中的第 K 个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 解答：
 * - 定义一个大小为 k 的 PriorityQueue
 * - 定义 PriorityQueue 的升序和降序（默认升序）
 *   - 升序：`PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);`
 *   - 降序：`PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);`
 */

public class $215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
