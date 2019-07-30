package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：将有序数组转换为（平衡）二叉搜索树
 *
 * 解答：本题的递归过程比较简单，用有序数组中最中间的数生成搜索二叉树的头节点，然后用这个数左边的数生成左子树，用右边的数生成右子树。
 */
public class $108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode head = generate(nums, 0, nums.length-1);
        return head;
    }
    private TreeNode generate(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generate(nums, start, mid-1);
        node.right = generate(nums, mid+1, end);
        return node;
    }

}
