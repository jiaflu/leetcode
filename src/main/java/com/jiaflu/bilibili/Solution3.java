package com.jiaflu.bilibili;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<List<String>> res = new ArrayList<>();
        String[] strs = input.split("#");

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < 3) {
                continue;
            }
            String[] tmp = strs[i].split(":");
            List<String> list = new ArrayList<>();
            for (int j = 0; j < tmp.length; j++) {
                if (" ".equals(tmp[j])){
                    continue;
                } else {
                    String[] sss = tmp[j].split(" ");
                    for (int k = 0; k < sss.length; k++) {
                        if (sss[k].length() > 0) {
                            list.add(sss[k]);
                        }
                    }
                    //list.add(tmp[j]);
                }
            }
            res.add(list);
        }

        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0) + " " + res.get(i).get(1));
        }
    }
}
