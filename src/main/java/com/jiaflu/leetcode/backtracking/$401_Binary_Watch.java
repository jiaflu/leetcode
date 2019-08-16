package com.jiaflu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 解答：
 * - 小时为 12 或者 分钟为 60 的不存在
 * - 回溯
 */

public class $401_Binary_Watch {
    static List<String> list = new ArrayList<>();
    public static List<String> readBinaryWatch(int num) {
        list.clear();
        if (num == 0) {
            list.add("0:00");
            return list;
        }
        int[] arr = new int[10];
        search(arr, num, 0, 0);
        return list;
    }

    private static void search(int[] arr, int num, int count, int index) {
        if (count >= num) {
            StringBuilder builder = new StringBuilder();
            int sum = 0;
            for (int i = 3; i >= 0; i--) {
                if (arr[i] == 1) {
                    sum += Math.pow(2, Math.abs(i-3));
                }
            }
            if (sum >= 12) return;
            builder.append(sum).append(":");
            sum = 0;
            for (int i = 9; i >= 4; i--) {
                if (arr[i] == 1) {
                    sum += Math.pow(2, Math.abs(i-9));
                }
            }
            if (sum >= 60) return;
            if (sum >= 10) {
                builder.append(sum);
            } else {
                builder.append("0").append(sum);
            }
            list.add(builder.toString());
            return;
        }
        if (index >= 10) {
            return;
        }
        arr[index] = 1;
        search(arr, num, count+1, index+1);
        arr[index] = 0;
        search(arr, num, count, index+1);
    }

}
