package com.jiaflu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 解答：
 * - 二维数组的排序
 */

public class $56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.toArray();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        boolean[] flag = new boolean[intervals.length];
        for (int k = 0; k < flag.length; k++) {
            flag[k] = true;
        }
        int i, j;
        int cnt = 1;
        for (i = 0, j = 1; i < intervals.length-1 && j < intervals.length;) {
            int end = intervals[i][1];
            int start = intervals[j][0];
            if (end >= start) {
                intervals[i][1] = Math.max(end, intervals[j][1]);
                flag[j] = false;
                j++;
            } else {
                flag[i] = true;
                i=j;
                j++;
                cnt++;
            }
        }
        int[][] tmp = new int[cnt][2];
        for (i = 0, j = 0; i < intervals.length; i ++) {
            if (flag[i] == true) {
                tmp[j][0] = intervals[i][0];
                tmp[j][1] = intervals[i][1];
                j++;
            }
        }
        return tmp;
    }
}
