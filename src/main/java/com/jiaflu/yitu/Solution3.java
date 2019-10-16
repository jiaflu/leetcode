package com.jiaflu.yitu;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        Arrays.sort(v);
        int sum = n;
        int start = 0, end = 1;
        for (; end < n; end++) {
            if (v[start] * 2 <= v[end]) {
                start++;
                sum--;
            }
        }
        System.out.println(sum);
    }

}
