package com.jiaflu.leetcode.breadth_firstSearch;

/**
 * 题目：岛屿的数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * 解答：
 * - bfs
 */

public class $200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] isvisit = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && isvisit[i][j] == false) {
                    num++;
                    bfs(i, j, grid, isvisit);
                }
            }
        }
        return num;
    }

    private void bfs(int a, int b, char[][] grid, boolean[][] isvisit) {
        if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length || isvisit[a][b] == true || grid[a][b] == '0') {
            return;
        }
        isvisit[a][b] = true;
        bfs(a - 1, b, grid, isvisit);
        bfs(a, b - 1, grid, isvisit);
        bfs(a + 1, b, grid, isvisit);
        bfs(a, b + 1, grid, isvisit);
    }
}
