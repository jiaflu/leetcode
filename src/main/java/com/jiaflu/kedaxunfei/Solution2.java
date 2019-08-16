package com.jiaflu.kedaxunfei;

import java.util.Scanner;

public class Solution2 {
    static int index = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            index = -1;
            String str = in.nextLine();
            String tmp = str.substring(1, str.length()-1);
            if (tmp.isEmpty()) {
                System.out.println(index);
                continue;
            }
            String[] strs = tmp.split(",");
            int[] arr = new int[strs.length + 1];
            for (int i = 1; i <= strs.length; i++) {
                arr[i] = Integer.valueOf(strs[i-1]);
            }

            int target = 19;
            search(arr, 1, arr.length-1, target);
            System.out.println(index);
        }
    }

    private static void search(int[] arr, int left, int right, int target) {
        if (index != -1 || left < 1 || right > arr.length || left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (target == arr[mid]) {
            index = mid;
            return;
        }
        if (target < arr[mid]) {
            search(arr, left, mid-1, target);
        } else if (target > arr[mid]) {
            search(arr, mid+1, right, target);
        }
    }
}
