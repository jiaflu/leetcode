package com.jiaflu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 解答：
 * - 注意 List 的深拷贝
 */

public class $78_Subsets {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        generate(list, 0, nums);
        return lists;
    }

    private void generate(List<Integer> list, int cnt, int[] nums) {
        if (cnt == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                tmp.add(list.get(i));
            }
            lists.add(tmp);
            return;
        }
        list.add(nums[cnt]);
        generate(list, cnt+1, nums);
        list.remove(list.size()-1);
        generate(list, cnt+1, nums);
    }
}
