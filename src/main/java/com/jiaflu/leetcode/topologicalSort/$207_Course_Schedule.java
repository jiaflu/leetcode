package com.jiaflu.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 * 解答：
 * - 拓扑排序（Kahn 算法）
 */
public class $207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        int plen = prerequisites.length;
        if (plen == 0) return true;
        // 入度数组,通过结点的索引,能够得到这个节点的后继结点个数
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        // 拓扑排序的结果
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer num = queue.removeFirst();
            res.add(num);
            // 把邻边全部遍历一下
            for (int[] p : prerequisites) {
                if (p[1] == num) {
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) {
                        queue.addLast(p[0]);
                    }
                }
            }
        }
        // System.out.println("拓扑排序结果：");
        // System.out.println(res);
        return res.size() == numCourses;
    }
}
