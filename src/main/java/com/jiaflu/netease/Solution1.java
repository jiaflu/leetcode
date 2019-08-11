package com.jiaflu.netease;

import java.text.DecimalFormat;
import java.util.*;


/**
 * 题目：小易的英语软件
 *
 * 思路：
 * - list 记录分数,index
 * - 根据 query 输入的 index 去 list 查询该分数 tmp
 * - 遍历 list 计算 小于等于 tmp 的数量，求百分比
 * -  `DecimalFormat df = new DecimalFormat("0.000000");`
 *    `res.add(df.format(resScore));`
 */

public class Solution1 {

    public static void main(String[] args) {
        int n, q;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        List<String> res = new ArrayList<>(); // 记录最近 百分比 结果

        List<Integer> tmpList = new ArrayList<>();
        double[] list = new double[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt(); // 分数记录,查询的时候输入 index
        }

        q = in.nextInt();
        while (q > 0) {
            int temp = in.nextInt();
            tmpList.add(temp);
            int count = 0;
            // 找出 list 中 小于等于 list[temp-1] 的个数，用于求百分比
            for (int i = 0; i < n; i++) {
                if (temp-1 == i) {
                    continue;
                }
                if (list[temp-1] >= list[i]) {
                    count++;
                }
            }
            double resScore = (double) count * 100 / n;
            DecimalFormat df = new DecimalFormat("0.000000");
            res.add(df.format(resScore));
            q--;
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    public static void prodess(int[] arr, int[] arrQ) {

    }


}
