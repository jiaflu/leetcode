package com.jiaflu.leetcode.bitManipulation;

/**
 * 题目：比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 *
 * 解答：
 * - 垃圾方法
 * - 高阶使用动态规划
 */

public class $338_Counting_Bits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            int count = 0;
            while (tmp != 0) {
                if ((tmp & 1) == 1) {
                    count++;
                }
                tmp = tmp >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    // 动态规划
    public int[] countBits_(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            // 状态转移函数：P(x) = P(x/2) + (x % 2)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}
