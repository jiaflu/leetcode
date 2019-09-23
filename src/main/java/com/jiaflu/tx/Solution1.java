package com.jiaflu.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(in.nextLine());
            String input = in.nextLine();
            //System.out.println(input.indexOf('8'));
//            if (n < 11) {
//                res.add("NO");
//                continue;
//            } else if (n - input.indexOf('8') >= 11) {
//                res.add("YES");
//            }
            if (n - input.indexOf('8') >= 11) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
