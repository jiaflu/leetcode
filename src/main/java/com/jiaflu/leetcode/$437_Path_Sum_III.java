package com.jiaflu.leetcode;

/**
 * 题目：路径总和 III
 *
 * 解答：
 * - 双重递归
 * - 首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径
 */

public class $437_Path_Sum_III {
    int pathnumber;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathnumber;
    }

    private void Sum(TreeNode root, int sum) {
        if (root == null) return;;
        sum -= root.val;
        if (sum == 0) {
            pathnumber++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
