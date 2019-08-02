package com.jiaflu.leetcode.tree;


import com.jiaflu.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 题目：从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 解答：
 *
 */
public class $105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder){
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);

    }

    private TreeNode helper(int in_left, int int_right) {
        if (in_left == int_right) return null;
        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        // recursion
        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, int_right);
        return root;
    }
}
