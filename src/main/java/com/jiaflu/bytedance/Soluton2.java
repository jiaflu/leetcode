package com.jiaflu.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Soluton2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t1 = 0, t2 = 1, queue = 1;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int c = in.nextInt();
            arr[i][0] = t;
            arr[i][1] = c;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int t = arr[i][0];
            int c = arr[i][1];
            arr[i][0] = t;
            arr[i][1] = c;

            t2 += c;
            t1 = t + c;

            queue = queue + c - 1;
        }

        int res1 = Math.max(t1, t2);
        System.out.println(res1 + " " + queue);

    }

}
