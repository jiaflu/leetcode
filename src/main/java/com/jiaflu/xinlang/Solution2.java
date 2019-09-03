package com.jiaflu.xinlang;

import java.util.*;

public class Solution2 {
    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        List<String[]> l = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            String tmp = list[i];
            String[] num = tmp.split("\\.");
            l.add(num);
        }
        Collections.sort(l, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int i = 0;
                while (i < o1.length && i < o2.length) {
                    if (Integer.valueOf(o1[i]).equals(Integer.valueOf(o2[i]))) {
                        i++;
                        continue;
                    }
                    return Integer.valueOf(o1[i]) - Integer.valueOf(o2[i]);
                }
                return o1.length - o2.length;
            }
        });
        int i = 0;
        String[] num = l.get(0);
        StringBuilder builder = new StringBuilder();
        for (i = 0; i < num.length; i++) {
            builder.append(num[i]);
            if (i < num.length-1) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] list = input.split(", ");
        System.out.println(getMinVersion(list));
    }
}
