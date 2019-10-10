package com.jiaflu.youzan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            res.add(func(input));
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static int func(int input) {
        int num = input + 1;
        int end = (int) Math.sqrt(num);
        int cnt = 0;
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
