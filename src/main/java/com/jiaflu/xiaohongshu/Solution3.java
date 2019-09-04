package com.jiaflu.xiaohongshu;

import java.util.Scanner;

public class Solution3 {
    static int min;
    public static void main(String[] args) {
        min = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);
        int n, m, k;
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a][b] = 1;
        }
        if(n <= 0 || m <= 0) {
            System.out.println(0);
            return;
        }
        boolean[][] flag = new boolean[n][m];
        flag[0][0] = true;
        search(arr, flag, 0, 0, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }

    private static void search(int[][] arr, boolean[][] flag, int count, int a, int b) {
        if (a == arr.length-1 && b == arr[0].length-1) {
            if (min > count) {
                min = count;
            }
            return;
        }
        if (a < 0 || b < 0 || a >= arr.length || b >= arr[0].length) {
            return;
        }
        if (a+1 > 0 && a+1 < arr.length && flag[a+1][b] == false && arr[a+1][b] != 1) {
            flag[a+1][b] = true;
            search(arr, flag, count+1, a+1, b);
            flag[a+1][b] = false;
        }
        if (b+1 > 0 && b+1 < arr[0].length && flag[a][b+1] == false && arr[a][b+1] != 1) {
            flag[a][b+1] = true;
            search(arr, flag, count+1, a, b+1);
            flag[a][b+1] = false;
        }
        if (a-1 >= 0 && a-1 < arr.length-1 && flag[a-1][b] == false && arr[a-1][b] != 1) {
            flag[a-1][b] = true;
            search(arr, flag, count+1, a-1, b);
            flag[a-1][b] = false;
        }
        if (b-1 >= 0 && b-1 < arr[0].length-1 && flag[a][b-1] == false && arr[a][b-1] != 1) {
            flag[a][b-1] = true;
            search(arr, flag, count, a, b-1);
            flag[a][b-1] = false;
        }

    }
}
