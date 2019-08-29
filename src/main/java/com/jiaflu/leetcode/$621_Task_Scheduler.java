package com.jiaflu.leetcode;

/**
 * 题目：任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *
 * 解答：
 * - (max-1)*(n+1) + count
 * - 找出 max 为频率最高的任务数,中间间隔 n 不用管是什么,就是用来填充的
 *
 */

public class $621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        //max 为频率最高的任务数
        //count 为频率最高的不同任务的个数
        int max = 0, count = 0;
        for (int i = 0; i < tasks.length; i++) {
            c[tasks[i]-'A']++;
            if (max < c[tasks[i]-'A']) {
                max = c[tasks[i]-'A'];
                count = 1;
            } else if (c[tasks[i]='A'] == max) {
                count++;
            }
        }
        if (n == 0 || (max-1) * (n+1) + count < tasks.length) {
            return tasks.length;
        }
        return (max-1) * (n+1) + count;
    }
}
