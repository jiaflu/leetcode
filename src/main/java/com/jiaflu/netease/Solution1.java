package com.jiaflu.netease;

import java.text.DecimalFormat;
import java.util.*;


/**
 * 题目：小易的英语软件
 *
 * 有多种不同的做法。这里介绍一种比较好理解的：桶排 + 前缀和。
 * 分数只有 151151 种，考虑对于每一种分数开一个桶 buc_ibuc
 * i
 * ​
 *  ，表示分数等于 ii 的人数，输入的时候就可以搞定。
 * 现在分数不超过 ss 的人数，就是求：buc_0 + buc_1 + \cdots + buc_sbuc
 * 0
 * ​
 *  +buc
 * 1
 * ​
 *  +⋯+buc
 * s​
 *
 * 这个用前缀和可以快速求出。
 * 最后要求输出百分数，这个在纸上推一下就好了。
 */

public class Solution1 {

    public static void main(String[] args) {
        int n, q;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        List<String> res = new ArrayList<>();

        List<Integer> tmpList = new ArrayList<>();
        double[] list = new double[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }

        q = in.nextInt();
        while (q > 0) {
            int temp = in.nextInt();
            tmpList.add(temp);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (temp -1 == i) {
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
