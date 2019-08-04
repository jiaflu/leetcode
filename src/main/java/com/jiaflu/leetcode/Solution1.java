package com.jiaflu.leetcode;

import com.jiaflu.generics.Box;

public class Solution1 {
    public static void main(String[] args) {
        Box<Integer> b = new Box<>();
        b.set(1);
        System.out.println(b.get());
    }
}
