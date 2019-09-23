package com.jiaflu.netease2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            res.add(func(A, B, p, q));
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static int func(int A, int B, int p, int q) {
        int cnt = 0;
        // 若 A+p < B,都执行 p = p*q
        while (A < B) {
            if (A + p >= B) {
                A = A + p;
                cnt++;
                break;
            } else {
                p = p * q;
                cnt++;
            }
        }
        return cnt;
    }
}
