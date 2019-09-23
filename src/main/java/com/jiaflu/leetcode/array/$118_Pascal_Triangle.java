package com.jiaflu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：杨辉三角
 *
 * 解答：
 *
 */

public class $118_Pascal_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> prefix = new ArrayList<>();
        prefix.add(1);
        res.add(prefix);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < prefix.size(); j++) {
                temp.add(prefix.get(j) + prefix.get(j-1));
            }
            temp.add(1);
            res.add(temp);
            prefix = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        generate(6);
    }
}
