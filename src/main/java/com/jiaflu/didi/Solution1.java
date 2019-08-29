package com.jiaflu.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        String[] arr = str.split(" ");
        int start = 0, end = 0;
        int flag = 0;
        List<Integer> list = new ArrayList<>();
        for (end = 0; end < arr.length; end++) {
            if (("*".equals(arr[end]) || "/".equals(arr[end]))) {
                if (flag == 0) { // 前面为+-
                    list.sort((a, b) -> a-b);
                    int index = 0;
                    for (; start < end; start++) {
                        if (!"*".equals(arr[end]) && !"/".equals(arr[end])
                                && "+".equals(arr[end]) && "-".equals(arr[end])
                                && index < list.size()) {
                            arr[start] = String.valueOf(list.get(index++));
                        }
                    }
                    list.clear();
                    list.add(Integer.valueOf(arr[end]));
                    flag = 1;
                } else {
                    continue;
                    //list.add(Integer.valueOf(arr[end]));
                }
                continue;
            }
            if ("+".equals(arr[end]) || "-".equals(arr[end])) {
                if (flag == 0) {
                    continue;
                    //list.add(Integer.valueOf(arr[end]));
                } else { // 前面为 * /
                    list.sort((a, b) -> a-b);
                    int index = 0;
                    for (; start < end; start++) {
                        if (!"*".equals(arr[end]) && !"/".equals(arr[end])
                                && "+".equals(arr[end]) && "-".equals(arr[end])
                                && index < list.size()) {
                            arr[start] = String.valueOf(list.get(index++));
                        }
                    }
                    list.clear();
                    list.add(Integer.valueOf(arr[end]));
                    flag = 0;
                }
                continue;
            }
            list.add(Integer.valueOf(arr[end]));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
