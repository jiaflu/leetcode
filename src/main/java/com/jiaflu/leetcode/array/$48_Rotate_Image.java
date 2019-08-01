package com.jiaflu.leetcode.array;

/**
 * 题目：旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 条件：
 * - 原地旋转
 *
 * 解答：
 * - 转置矩阵
 * - 反转每一行
 *
 */

public class $48_Rotate_Image {
    public void rotate(int[][] matrix) {
        // 转置矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 反转每一行
        for (int i = 0; i < matrix.length; i++) {
            int start = 0, end = matrix.length - 1;
            while (start < end) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }
    }
}
