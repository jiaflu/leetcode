package com.jiaflu.xiaohongshu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    static int res = 0;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String str = in.next();
//        String subStr = str.substring(1, str.length()-1);
        int n = 10;
        int[] arr = new int[]{2,3,5};
        backtrace(n, arr, 0, 0, new ArrayList<>());
        System.out.println(res);
    }

    public static void backtrace(int n, int[] arr, int cnt, int index, List<Integer> list) {
        if (index >= arr.length) return;
        if (cnt == n) {
            List<Integer> tmp = new ArrayList<>();
            for (int i =0; i < list.size(); i++) {
                tmp.add(list.get(i));
            }
            lists.add(list);
            res++;
        } else if (cnt > n) {
            return;
        }
        list.add(arr[index]);
        backtrace(n, arr, cnt + arr[index], index, list);
        backtrace(n, arr, cnt + arr[index], index+1, list);
        list.remove(list.size()-1);
        backtrace(n, arr, cnt, index+1, list);
    }
}
