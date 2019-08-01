package com.jiaflu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 解答：
 * - 回溯，比较抽象，再理解理解
 */

public class $46_Permutations {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, 0);
        return lists;
    }

    private void backtrack(int n, List<Integer> nums, int first){
        if (first == n) {
            lists.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            // place i-th integer fiest
            // in the current permutation
            Collections.swap(nums, first, i);
            backtrack(n, nums, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
