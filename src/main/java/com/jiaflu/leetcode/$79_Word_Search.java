package com.jiaflu.leetcode;

/**
 * 题目：单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 解答：
 * - 回溯 + dfs
 */

public class $79_Word_Search {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrace(i, j, 0, word, visited, board)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean backtrace(int i, int j, int idx, String word, boolean[][] visited, char[][] board) {
        if (idx == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (backtrace(i+1, j, idx + 1, word, visited, board) || backtrace(i - 1, j, idx + 1, word, visited, board)
                || backtrace(i, j + 1, idx + 1, word, visited, board) || backtrace(i, j - 1, idx + 1, word, visited, board)) {
            return true;
        }
        visited[i][j] = false;
        return false;

    }
}
