package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 解答：
 * 对于任意一个节点，如果最大和路径包含该节点，那么只可能有两种情况：
 * - 其左右子树中所构成的和路径值较大那个加上该节点的值后向父节点回溯构成最大路径；
 * - 左右子树都在最大路径中，加上该节点的值构成了最终的最大路径；
 */
public class $124_Binary_Tree_Maximum_Path_Sum {
    private int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if (r == null) return 0;
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));
        int right = Math.max(0, getMax(r.right));
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        ret = Math.max(ret, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}
