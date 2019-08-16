package com.jiaflu.kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    list.add(c - '0');
                }
            }
            if (list.isEmpty()){
                System.out.print(-1);
            }
            list.sort((a, b) -> {
                return a-b;
            });
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            System.out.println(builder.toString());
        }

    }


}
