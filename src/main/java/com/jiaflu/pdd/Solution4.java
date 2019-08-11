package com.jiaflu.pdd;

import java.util.*;

public class Solution4 {
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] li = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        boolean[] used = new boolean[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            used[i] = true;
            arrayList.add(i);
            find(n, li, w, used, i, arrayList);
            arrayList.remove(arrayList.size() - 1);
            used[i] = false;
        }
        System.out.println(ans);
    }

    public static void find(int n, int[] li, int[] w, boolean[] used, int pre, ArrayList<Integer> arrayList) {
        for (int i = 0; i < n; i++) {
            if (used[i] == false && li[i] < li[pre]) {
                used[i] = true;
                arrayList.add(i);
                if (judge(w, arrayList)) {
                    find(n, li, w, used, i, arrayList);
                }
                arrayList.remove(arrayList.size() - 1);
                used[i] = false;
            }
        }

    }

    public static boolean judge(int[] w, ArrayList<Integer> arrayList) {
        int sum = 0;
        boolean result = true;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (w[arrayList.get(i)] * 7 >= sum) {
                sum += w[arrayList.get(i)];
            } else {
                result = false;
            }
        }
        if (result) {
            ans = Math.max(ans, arrayList.size());
        }
        return result;
    }

}

