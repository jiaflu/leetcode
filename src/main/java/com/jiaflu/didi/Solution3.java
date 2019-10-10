package com.jiaflu.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String input = in.nextLine();
        String[] strs = input.split(" ");
        //List<String> operators = new ArrayList<>();
        //List<Integer> nums = new ArrayList<>();
        String[] operators = new String[n];
        int[] nums = new int[n];
        operators[0] = "+";

        int a = 0, b = 1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if ("+".equals(str) || "-".equals(str)
                    || "*".equals(str) || "/".equals(str)) {
                operators[b] = str;
                b++;
            } else if (!str.isEmpty()) {
                nums[a] = Integer.valueOf(str);
                a++;
            }
        }

        System.out.println("lal");

        int l = 0, r = 0;
        while (r < n) {
            while (r < n && operators[r].equals(operators[l])) {
                r++;
            }
            r--;
            if ("+".equals(operators[l]) || "-".equals(operators[l])) {
                if (r < n-1 && ("*".equals(operators[r+1]) || "/".equals(operators[r+1]))) {
                    Arrays.sort(nums, l, r);
                } else {
                    Arrays.sort(nums, l, r);
                }
            } else if ("*".equals(operators[l])) {
                if (l > 0 && ("+".equals(operators[l-1]) || "-".equals(operators[l-1]))) {
                    Arrays.sort(nums, l-1, r);
                } else {
                    Arrays.sort(nums, l, r);
                }
            } else if ("/".equals(operators[l])) {
                Arrays.sort(nums, l, r);
            }
            r++;
            l = r;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < n; i++) {
            sb.append(" ");
            sb.append(operators[i]);
            sb.append(" ");
            sb.append(nums[i]);
        }


        System.out.println(sb.toString());

    }
}
