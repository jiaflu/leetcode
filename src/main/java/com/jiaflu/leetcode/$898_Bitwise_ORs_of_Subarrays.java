package com.jiaflu.leetcode;

import java.util.*;

/**
 * 题目:子数组按位或操作
 * 我们有一个非负整数数组 A。
 *
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 *
 *
 * 解答：
 * - 注意是连续的子数组
 * - 回溯法超时,容易出错
 */

public class $898_Bitwise_ORs_of_Subarrays {
    Set<Integer> set = new HashSet<>();
    public int subarrayBitwiseORs(int[] A) {
        backtarce(A, 0, new ArrayList<>());
        return set.size();
    }

    private void backtarce(int[] A, int index, List<Integer> list) {
        if (index == A.length) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res |= list.get(i);
            }
            if (!list.isEmpty()) {
                set.add(res);
            }
            return;
        }

        list.add(A[index]);
        backtarce(A, index+1, list);
        list.remove(list.size() - 1);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res |= list.get(i);
        }
        if (!list.isEmpty()) {
            set.add(res);
        }
        backtarce(A, index+1, new ArrayList<>());
    }
}
