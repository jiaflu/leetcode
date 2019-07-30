package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

/**
 * 题目：
 * 序列化和反序列化二叉搜索树
 */

public class $449_SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preorder(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        return buildBST(data, 0, data.length()-1);
    }


    private void preorder(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val);
        preorder(root.left, builder);
        preorder(root.right, builder);
    }

    private TreeNode buildBST(String data, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(Integer.valueOf(data.charAt(start)));
        int mid = start++;
        while (mid <= end) {
            if (data.charAt(mid) > data.charAt(start)) {
                break;
            }
            mid++;
        }
        root.left = buildBST(data, ++start, --mid);
        root.right = buildBST(data, mid, end);
        return root;
    }

}
