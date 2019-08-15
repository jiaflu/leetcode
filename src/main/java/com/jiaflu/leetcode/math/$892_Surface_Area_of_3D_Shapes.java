package com.jiaflu.leetcode.math;

/**
 * 题目：三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 解答：
 * - 双重循环
 * - 前后左右判断
 */

public class $892_Surface_Area_of_3D_Shapes {
    public static int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                sum += 2; // 上、下

                if (j+1 < grid[0].length) {
                    int tmp = grid[i][j] - grid[i][j+1];
                    if (tmp > 0) {
                        sum += tmp;
                    }
                } else {
                    sum += grid[i][j];
                }

                if (j > 0) {
                    int tmp = grid[i][j] - grid[i][j-1];
                    if (tmp > 0) {
                        sum += tmp;
                    }
                } else {
                    sum += grid[i][j];
                }
                if (i+1 < grid.length) {
                    int tmp = grid[i][j] - grid[i+1][j];
                    if (tmp > 0) {
                        sum += tmp;
                    }
                } else {
                    sum += grid[i][j];
                }

                if (i > 0) {
                    int tmp = grid[i][j] - grid[i-1][j];
                    if (tmp > 0) {
                        sum += tmp;
                    }
                } else {
                    sum += grid[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,4}};
        System.out.println(surfaceArea(arr));
    }
}
