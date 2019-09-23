package com.jiaflu.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            list.add(temp);
            if (min > temp) {
                min = temp;
            }
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            res.add(min);
            if (cnt == n) {
                min = 0;
                continue;
            }
            int tempMin = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                int lala = list.get(j);
                lala -= min;
                if (lala <= 0) {
                    list.set(j, lala);
                    cnt++;
                } else {
                    list.set(j, lala);
                    if (lala < tempMin) {
                        tempMin = lala;
                    }
                }
            }
            if (tempMin == Integer.MAX_VALUE) {
                min = 0;
            } else {
                min = tempMin;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }
}
