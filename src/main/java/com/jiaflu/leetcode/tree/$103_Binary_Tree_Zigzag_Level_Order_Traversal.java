package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.*;

/**
 * 题目：二叉树的锯齿形层次遍历
 *
 * 解答：
 * - 层次遍历
 * - Collections.reverse()
 */

public class $103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        tmp.addLast(root);
        int count = 1;
        List<Integer> l;
        boolean flag = true;
        while (!tmp.isEmpty()) {
            l = new ArrayList<>();
            int tmpCount = 0;
            while (count-- > 0) {
                TreeNode node = tmp.pollFirst();
                l.add(node.val);
                if (node.left != null) {
                    tmp.addLast(node.left);
                    tmpCount++;
                }
                if (node.right != null) {
                    tmp.addLast(node.right);
                    tmpCount++;
                }
            }
            if (flag == true) {
                lists.add(l);
            } else {
                Collections.reverse(l);
                lists.add(l);
            }
            flag = !flag;
            count = tmpCount;
        }
        return lists;
    }

}
