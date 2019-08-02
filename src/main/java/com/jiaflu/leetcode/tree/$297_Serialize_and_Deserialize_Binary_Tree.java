package com.jiaflu.leetcode.tree;

import com.jiaflu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 解答：
 * - 注意特殊测试用例 `[]`
 */
public class $297_Serialize_and_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                list.add(String.valueOf(node.val));
            } else {
                list.add("null");
                continue;
            }
            queue.addLast(node.left);
            queue.addLast(node.right);
        }
        while ("null".equals(list.get(list.size()-1))){
            list.remove(list.size()-1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String dataTmp = data.substring(1, data.length()-1);
        String[] strs = dataTmp.split(",");
        if (strs == null || strs.length == 0 || "".equals(strs[0])) return null;
        TreeNode node = new TreeNode(Integer.valueOf(strs[0]));
        TreeNode head = node;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(node);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode nodeTmp = queue.pollFirst();
            if (index < strs.length) {
                if ("null".equals(strs[index])) {
                } else {
                    int value = Integer.valueOf(strs[index]);
                    nodeTmp.left = new TreeNode(value);
                    queue.addLast(nodeTmp.left);
                }
                index++;
            }
            if (index < strs.length) {
                if ("null".equals(strs[index])) {
                } else {
                    int value = Integer.valueOf(strs[index]);
                    nodeTmp.right = new TreeNode(value);
                    queue.addLast(nodeTmp.right);
                }
                index++;
            }
        }
        return head;
    }
}
