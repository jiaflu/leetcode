package com.jiaflu.yuanfudao;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                if (map.get(arr[i]) > m) {
                    arr[i] = -1;
                }
            }
            for (int i=0; i < n; i++) {
                if (arr[i] != -1) {
                    System.out.print(arr[i]);
                }
                if (arr[i] != -1 && i < n-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();


        }
    }
}
