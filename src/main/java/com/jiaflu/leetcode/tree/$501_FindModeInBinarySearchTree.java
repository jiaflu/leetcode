package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：
 * 二叉搜索树中的众数
 *
 * 优化：不使用额外空间
 */

public class $501_FindModeInBinarySearchTree {

    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        preorderBST(root);

        List<Integer> list = new ArrayList<>();
        int max = -1;
        for (Integer val : map.keySet()) {
            if (max < map.get(val)) {
                max = map.get(val);
                list.clear();
                list.add(val);
            } else if (max == map.get(val)) {
                list.add(val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void preorderBST(TreeNode root) {
        if(root == null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preorderBST(root.left);
        preorderBST(root.right);
    }



}
