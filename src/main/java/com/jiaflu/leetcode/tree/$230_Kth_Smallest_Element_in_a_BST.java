package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 解答：
 * - 二叉搜索树的中序遍历
 */

public class $230_Kth_Smallest_Element_in_a_BST {

    static int count;
    static int res;
    public int kthSmallest(TreeNode root, int k) {
        // 注意,由于 leetcode 的测试方法原因,存在静态变量时,每次调用方法时需要初始化一下静态变量
        count = 0;
        res = 0;
        search(root, k);
        return res;
    }

    private void search(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        search(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        search(root.right, k);
    }

}
