package com.jiaflu.pdd;

import java.util.Scanner;

public class Solution7 {
    public static int res = 0;
    public static void main(String[] args) {
        // 初始化
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();

        process(0, 0, n, s, 1);
        System.out.println(res);
    }

    // 回溯
    public static void process(int count, int sum, int n, int s, int index) {
        if (count == n && sum == s) {
            res++;
            return;
        }
        if (count > n || sum > s || index > s) {
            return;
        }
        process(count+1, sum + index, n, s, index+1);
        process(count, sum, n, s, index+1);
    }
}
