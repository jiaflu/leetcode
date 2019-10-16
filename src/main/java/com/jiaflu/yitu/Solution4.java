package com.jiaflu.yitu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        Arrays.sort(v);
        int bigger = n - 1;
        int smaller = n - 2;
        int count = 0;
        while (smaller >= 0) {
            if (visited[bigger]) {
                bigger--;
                continue;
            }
            if ((v[smaller] << 1) > v[bigger]) {
                smaller--;
            } else {
                visited[smaller] = true;
                bigger--;
                smaller--;
                count++;
            }
        }
        System.out.println(n - count);
    }
}
