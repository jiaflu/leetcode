package com.jiaflu.leetcode.unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
 * 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 解答：
 * - 并查集
 */

public class $399_Evaluate_Division {
    Map<String, String> parents = new HashMap<>();
    Map<String, Double> vals = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        for (int i = 0; i < values.length; i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            res[i] = (parents.containsKey(x) && parents.containsKey(y) && find(x) == find(y) ? vals.get(x) / vals.get(y) : -1.0);
        }
        return res;
    }

    private void add(String s) {
        if (parents.containsKey(s)) {
            return;
        }
        parents.put(s, s);
        vals.put(s, 1.0);
    }

    private String find(String s) {
        String p = parents.getOrDefault(s, s);
        if (s != p) {
            String pp = find(p);
            vals.put(s, vals.get(s) * vals.get(p));
            parents.put(s, pp);
        }
        return parents.getOrDefault(s, s);
    }

    private void union(String x, String y, double v) {
        add(x);
        add(y);
        String px = find(x);
        String py = find(y);
        parents.put(px, py);
        vals.put(px, v * vals.get(y) / vals.get(x));
    }
}
