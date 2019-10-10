package com.jiaflu.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:有效的数独
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 解答：（一次迭代）
 * - 行中有没有重复的数字
 * - 列中有没有重复的数字
 * - 3*3 子数独内有没有重复的数字（关键）
 */

public class $36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer> [] rows = new HashMap[9];
        Map<Integer, Integer> [] columns = new HashMap[9];
        Map<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = Integer.valueOf(num);

                    // 把大数独切分成编号 0->8 的子数独（关键）
                    int box_index = (i/3)*3 + j/3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n,0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
