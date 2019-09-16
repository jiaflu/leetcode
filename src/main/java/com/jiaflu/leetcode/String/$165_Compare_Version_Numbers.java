package com.jiaflu.leetcode.String;

/**
 * 题目：比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 示例 1:
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 *
 * 解答：
 * - String 比较
 */

public class $165_Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.isEmpty() || version2.isEmpty()) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (i = 0; i < v1.length && i < v2.length; i++) {
            int a = Integer.valueOf(v1[i]);
            int b = Integer.valueOf(v2[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                continue;
            }
        }
        if (i < v1.length) {
            for (int j = i; j < v1.length; j++) {
                if (Integer.valueOf(v1[j]) > 0) {
                    return 1;
                }
            }
        }
        if (i < v2.length) {
            for (int j = i; j < v2.length; j++) {
                if (Integer.valueOf(v2[j]) > 0) {
                    return -1;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
