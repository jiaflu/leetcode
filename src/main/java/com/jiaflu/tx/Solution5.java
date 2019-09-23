package com.jiaflu.tx;

import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++){
            int temp = in.nextInt();
            int cnt = map1.getOrDefault(temp, 0);
            if (cnt == 0) {
                map1.put(temp, 1);
            } else {
                map1.remove(temp);
            }
        }
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            int cnt = map2.getOrDefault(temp, 0);
            if (cnt == 0) {
                map2.put(temp, 1);
            } else {
                map2.remove(temp);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map1.keySet()) {
            for (Integer j : map2.keySet()) {
                list.add(i+j);
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res ^= list.get(i);
        }

        System.out.println(res);
    }
}
