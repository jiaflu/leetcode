package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 * 解答：
 *
 */

public class $173_Binary_Search_Tree_Iterator {
    class BSTIterator {
        List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            inOrder(root);
        }

        /** @return the next smallest number */
        public int next() {
            return list.remove(0);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (list.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

}
