package com.jiaflu.leetcode.backtracking;

import java.util.*;

/**
 * 题目：复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 解答：
 * - dfs
 * - 如果起为 0,只能 0, 不能 012 等,注意此次回溯
 */

public class $93_Restore_IP_Addresses {
    static List<String> res = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        search(s, "", 0, 0);
        return res;
    }

    public static void search(String s, String ip, int index, int cnt) {
        if (index == s.length() && cnt == 4) {
            res.add(ip);
        }
        if (index >= s.length() || cnt > 4) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                return;
            }
            String temp = s.substring(index, index + i);
            int num = Integer.valueOf(temp);
            if (num >= 0 && num <= 255) {
                if (cnt < 3) {
                    temp += ".";
                }
                search(s, ip+temp, index+i, cnt+1);
            }
            if (s.charAt(index) == '0') {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
        //System.out.println("abcdef".substring(2,9));
    }
}
