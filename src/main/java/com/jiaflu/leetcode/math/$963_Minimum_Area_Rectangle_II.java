package com.jiaflu.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最小面积矩形 II
 * 给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
 * 如果没有任何矩形，就返回 0。
 *
 * 解答：
 * - 遍历每两个点的组合，记录他俩 对角线的长度 和 中点坐标，拼成字符串存进map的key，把其中一个点的坐标存进value(方便以后计算面积面积)。
 * - 之后再遇到 长度和中点 相同的一组点，就获取key对应的value(们)， 分别算出面积，取最小的返回，再把当前的一个点坐标和value拼起来覆盖原value
 *
 * - 形成一个矩形的充分必要条件是两条对角线的中点相同且端点到中点距离也相同。
 */

public class $963_Minimum_Area_Rectangle_II {
    public double minAreaFreeRect(int[][] points) {
        Map<String, String> state = new HashMap<>();
        double S = Long.MAX_VALUE;
        // 遍历每两个点的组合
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                long x1 = points[i][0];
                long y1 = points[i][1];
                long x2 = points[j][0];
                long y2 = points[j][1];
                long x = x1 - x2;
                long y = y1 - y2;
                // 求对角线长度
                double l = Math.pow(x*x + y*y, 0.5);
                // 求中点坐标
                double midx = (x1+x2) / 2.0;
                double midy = (y1+y2) / 2.0;
                // key
                String st = l + "," + midx + ";" + midy;
                if (state.containsKey(st)) {
                    String temp = state.get(st);
                    double s = check(temp, x1, x2, y1, y2);
                    // 对角线长度为 l，中点为 [midx,midy] 的已算过
                    state.put(st, temp + x1 + "," + y1 + ";");
                    if (s < S) {
                        S = s;
                    }
                } else {
                    state.put(st, x1 + "," + y1 + ";");
                }
            }
        }
        if (S == Long.MAX_VALUE) {
            S = 0;
        }
        return S;
    }

    // 知道一个矩形的中点和任意两个端点，可以求出其面积
    private double check(String ss, long x1, long x2, long y1, long y2) {
        String[] strs = ss.split(";");
        double min = Long.MAX_VALUE;
        for (String str : strs) {
            String[] strr = str.split(",");
            // 另一条对角线中的一个点
            long sx = Long.parseLong(strr[0]);
            long sy = Long.parseLong(strr[1]);
            double c = Math.pow((x1-sx)*(x1-sx) + (y1-sy)*(y1-sy), 0.5);
            double k = Math.pow((x2-sx)*(x2-sx) + (y2-sy)*(y2-sy), 0.5);
            double S = c * k;
            if (S < min) {
                min = S;
            }
        }
        return min;
    }
}
