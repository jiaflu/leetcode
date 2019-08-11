package com.jiaflu.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int[] arrQuery = new int[q];
        for (int i = 0; i < q; i++) {
            arrQuery[i] = in.nextInt();
        }

        List<Integer> list = process(arr, arrQuery);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static List<Integer> process(int[] arr, int[] arrQuery) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrQuery.length; i++) {
            int tmp = arrQuery[i];
            int cnt = 0;
            // 时间复杂度过高,优化位二分查找
            for (int j = 0; j < arr.length; j++) {
                if (tmp <= arr[j]) {
                    arr[j] = arr[j] - 1;
                    cnt++;
                }
            }
            list.add(cnt);
        }
        return list;
    }

}
