package com.jiaflu.kuaishou;

import sun.net.util.IPAddressUtil;
import java.util.Scanner;

/**
 * 题目：判断ip是否为ipv6或ipv4
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (isIPv4LiteralAddress(input)) {
            System.out.println("IPv4");
        } else if (IPAddressUtil.isIPv6LiteralAddress(input)) {
            System.out.println("IPv6");
        } else {
            System.out.println("IPv6");
        }
    }

    private static boolean isIPv4LiteralAddress(String ip) {
        String[] part = ip.split("\\.");
        for (String s : part) {
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return true;
    }
}
