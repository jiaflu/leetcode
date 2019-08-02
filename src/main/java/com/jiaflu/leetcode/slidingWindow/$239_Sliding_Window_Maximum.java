package com.jiaflu.leetcode.slidingWindow;

import java.util.LinkedList;

/**
 * 题目：滑动窗口的最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 解答：
 * - 双向队列
 * - 思路：
 *   - 遍历数组，将数存放在双向队列中，并用L,R来标记窗口的左边界和右边界。
 *   - 队列中保存的并不是真的数，而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。
 *   - 如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。
 *   - 刚开始遍历时，L和R都为0，有一个形成窗口的过程，此过程没有最大值，L不动，R向右移。
 *   - 当窗口大小形成时，L和R一起向右移，==每次移动时，判断队首的值的数组下标是否在[L,R]中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。==
 */
public class $239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2)  return nums;
        // 双向队列 保存当前窗口最大值的数组位置，保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历 nums 数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要弹出，直至满足需求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效****
            if (queue.peek() <= i - k){
                queue.poll();
            }
            // 当窗口长度为 k 时，保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
