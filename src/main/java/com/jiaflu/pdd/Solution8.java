package com.jiaflu.pdd;

import java.util.Scanner;

public class Solution8 {
    public static void main(String[] args) {
        // 初始化
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
        }

        if (m == 0) {
            System.out.println(n);
        }

    }
}
