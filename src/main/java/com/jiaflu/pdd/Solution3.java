package com.jiaflu.pdd;

import java.util.*;

/**
 * 题目：
 * - 拓扑排序
 * - 最优解
 */

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        // 节点权重
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        // 节点指向,反向
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (arrayLists[y] == null) {
                arrayLists[y] = new ArrayList<>();
            }
            arrayLists[y].add(x);
        }

        // 记录节点是否被访问过
        boolean[] reslove = new boolean[n + 1];
        int sum = 0;
        // 存放结果
        ArrayList<Integer> res = new ArrayList<>();
        while (sum != n) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 1; i <= n; i++) {
                if (reslove[i] == false && (arrayLists[i] == null || arrayLists[i].size() == 0)) {
                    if (p[i] < min) {
                        min = p[i];
                        index = i;
                    }
                }
            }
            reslove[index] = true;
            sum++;
            res.add(index);
            // 删除与该节点相连的边
            for (int i = 1; i <= n; i++) {
                if (reslove[i] == false && (arrayLists[i] != null && arrayLists[i].contains(index))) {
                    arrayLists[i].remove((Object)index);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(res.get(i));
        }

    }
}
