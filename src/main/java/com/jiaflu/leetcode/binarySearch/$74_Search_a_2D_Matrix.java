package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 解答：
 * - 先纵向二分查找
 * - 再横向二分查找
 * - 注意两个特殊测试用例：
 *      1.matrix:[[]], target:0
 *      2.matrix:[[1]], target:0
 */

public class $74_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 处理特殊情况 matrix:[[]], target:0
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int col1 = 0, col2 = matrix.length-1;
        int row1 = 0, row2 = matrix[0].length-1;

        int mid_col = -1;
        while (col1 <= col2) {
            mid_col = col1 + (col2 - col1) / 2;
            if (target < matrix[mid_col][0]) {
                col2 = mid_col - 1;
            } else if (target > matrix[mid_col][0]) {
                col1 = mid_col + 1;
            } else {
                return true;
            }
        }

        if (matrix[mid_col][0] > target) {
            mid_col -= 1;
        }
        // 处理特殊情况 matrix:[[1]], target:0
        if (mid_col < 0) return false;

        int mid_row = -1;
        while (row1 <= row2) {
            mid_row = row1 + (row2 - row1) / 2;
            if (target < matrix[mid_col][mid_row]) {
                row2 = mid_row - 1;
            } else if (target > matrix[mid_col][mid_row]) {
                row1 = mid_row + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
