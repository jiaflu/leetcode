package com.jiaflu.bilibili;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i + arr[i-1];
        }
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (arr[j] - arr[i] == n) {
                    cnt++;
                }
                if (arr[j] - arr[i] > n) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
