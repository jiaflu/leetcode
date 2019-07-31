package com.jiaflu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * - 所有数字（包括 target）都是正整数。
 * - 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 解答：
 *- 递归
 * - List 的拷贝
 * - 去重
 * - 遗留问题：时间复杂度较高，有空进行剪枝
 */

public class $39_CombinationSum {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        generate(candidates, target, 0, list);
        return lists;
    }

    private void generate(int[] candidates, int target, int sum, List<Integer> list) {
        if (sum == target) {
            // 拷贝 list
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                tmp.add(list.get(j));
            }
            lists.add(tmp);
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                // 去重
                if (!list.isEmpty() && candidates[i] < list.get(list.size()-1)) {
                    continue;
                }
                list.add(candidates[i]);
                generate(candidates, target, sum + candidates[i], list);
                list.remove(list.size()-1);
            }
        }
    }
}
