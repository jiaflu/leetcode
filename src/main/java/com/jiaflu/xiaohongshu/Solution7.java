package com.jiaflu.xiaohongshu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(in.nextInt());
            tmp.add(in.nextInt());
            list.add(tmp);
        }
        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0))) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return o1.get(0) - o2.get(0);
                }
            }
        });
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(j).get(1) <= list.get(i).get(1)) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        System.out.print(dp[list.size() - 1]);
    }
}

