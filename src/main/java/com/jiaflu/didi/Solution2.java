package com.jiaflu.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
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
//            if (("*".equals(arr[end]) || "/".equals(arr[end]))) {
//
//                continue;
//            }
//            if ("+".equals(arr[end]) || "-".equals(arr[end])) {
//                continue;
//            }
            if (end + 1 >= arr.length) {
                break;
            }
            String temp = arr[end+1];
            if (flag == 0 && ("*".equals(temp) || "/".equals(temp))) {
                list.sort((a, b) -> a-b);
                int index = 0;
                for (; start < end; start++) {
                    if (!"*".equals(arr[start]) && !"/".equals(arr[start])
                            && !"+".equals(arr[start]) && !"-".equals(arr[start])
                            && index < list.size()) {
                        arr[start] = String.valueOf(list.get(index++));
                    }
                }
                list.clear();
                //list.add(Integer.valueOf(arr[end]));
                flag = 1;
            } else if (flag == 1 && ("+".equals(temp) || "-".equals(temp))) {
                list.sort((a, b) -> a-b);
                int index = 0;
                for (; start < end; start++) {
                    if (!"*".equals(arr[start]) && !"/".equals(arr[start])
                            && !"+".equals(arr[start]) && !"-".equals(arr[start])
                            && index < list.size()) {
                        arr[start] = String.valueOf(list.get(index++));
                    }
                }
                list.clear();
                //list.add(Integer.valueOf(arr[end]));
                flag = 0;
            }
            list.add(Integer.valueOf(arr[end]));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
