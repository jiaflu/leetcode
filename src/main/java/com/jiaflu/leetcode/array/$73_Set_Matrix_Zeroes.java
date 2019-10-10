package com.jiaflu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：矩阵置零
 *
 * 解答：
 *
 */


public class $73_Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (Integer i : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer i : column) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }

}
