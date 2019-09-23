package com.jiaflu.netease2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int temp = in.nextInt();
            res.add(func(temp));
            func(temp);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static String func(int num) {
        int cnt = num / 9;
        int m = num % 9;
//        Long sum = Long.valueOf(m);
//        for (int i = 0; i < cnt; i++) {
//            sum = sum*10 + 9;
//        }
//        return sum;
        StringBuilder sb = new StringBuilder();
        if (m == 0 && cnt > 0) {

        } else {
            sb.append(m);
        }
        for (int i = 0; i < cnt; i++) {
            sb.append(9);
        }
        return sb.toString();
    }
}
