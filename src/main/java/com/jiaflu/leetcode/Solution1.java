package com.jiaflu.leetcode;

import com.jiaflu.generics.Box;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        String a = new String("12");
        List list = Arrays.asList(a);
        list.clear();
        list.add(3);
        System.out.println(list.toString());
    }
}
