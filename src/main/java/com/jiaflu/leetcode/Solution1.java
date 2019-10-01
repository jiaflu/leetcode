package com.jiaflu.leetcode;

import com.jiaflu.generics.Box;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "abcdef";
        byte[] b1 = str1.getBytes();
        byte[] b2 = str2.getBytes();

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }
}
