package com.jiaflu.pdd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 思路：
 * - 分割
 * - 排序
 * - 取
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] tmp = input.split(";");
        String str1 = tmp[0];
        String str2 = tmp[1];

        String[] arrStr = str1.split(",");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arrStr.length; i++) {
            int num = Integer.valueOf(arrStr[i]);
            if (num % 2 == 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }

        int n = Integer.valueOf(str2);

        list1.sort((a, b) -> b - a);
        list2.sort((a, b) -> b - a);
        List<Integer> res = new ArrayList<>();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < n; i++) {
            if (index1+1 <= list1.size()) {
                System.out.print(list1.get(index1));
                index1++;
            } else {
                System.out.print(list2.get(index2));
                index2++;
            }
            if (i < n-1) {
                System.out.print(",");
            }
        }
    }
}
