package com.jiaflu.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(search(arr, n, t, m));
    }

    public static int search(int[] arr, int n, int t, int m) {
        Arrays.sort(arr);
        int left = arr[0], right = arr[arr.length-1];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int tmpT = t, tmpM = m;
            int mid = left + (right - left) / 2;
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (tmpT <= 0 && tmpM <= 0) {
                    flag = false;
                    break;
                }
                if (arr[j] == 1) {
                    tmpT--;
                } else {
                    int cnt = arr[j] / mid;
                    tmpM -= cnt;
                    tmpT -= cnt;
                    if (arr[j] % mid != 0) {
                        if (arr[j] % mid == 1) {
                            tmpT--;
                        } else {
                            tmpT--;
                            tmpM--;
                        }
                    }
                }
            }
            if (flag == false) {
                left = mid + 1;
            } else {
                if (min > right) {
                    min = right;
                }
                right = mid;
            }
        }
        return min;
    }

}
