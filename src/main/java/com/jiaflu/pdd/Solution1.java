package com.jiaflu.pdd;

import java.util.*;


/**
 * 题目：
 * 几乎严格升序：即只要改变其中一个数字,即可满足完全升序排序
 *
 * 示例：
 * 输入：1 3 7 4 10
 *      2 1 5 8 9
 * 输出：1 3 7 9 10
 *
 * 输入：20 1 23
 *      50 26 7
 * 输出：NO
 */
public class Solution1 {

    public static void main(String[] args) {
        find();
    }

    public static void find() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String[] a1 = a.split(" ");
        String[] b1 = b.split(" ");
        if (a1.length <= 1 || b1.length == 0) {
            System.out.println("NO");
            return;
        }

        int[] x = new int[a1.length];
        int pre = 0;
        int next = 0;
        int index = -1;

        for (int i = 0; i < a1.length; i++) {
            x[i] = Integer.valueOf(a1[i]);
        }

        int[] y = new int[b1.length];
        for (int i = 0; i < b1.length; i++) {
            y[i] = Integer.valueOf(b1[i]);
        }
        // 以上都是初始化操作

        Arrays.sort(y);

        for (int i = 0; i < a1.length; i++) {
            if (i == 0) {
                if (x[i] >= x[i + 1]) {
                    next = x[i + 1];
                    pre = Integer.MIN_VALUE;
                    index = 0;
                    break;
                } else {
                    pre = x[i];
                }
            } else {
                if (x[i] <= pre) {
                    if (i == a1.length - 1) {
                        next = Integer.MIN_VALUE;
                        index = i;
                    } else {
                        next = x[i + 1];
                        index = i;
                    }
                    break;
                } else {
                    pre = x[i];
                }
            }

        }

        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < b1.length; i++) {
            if (pre != Integer.MIN_VALUE && y[i] <= pre) {
                continue;
            }
            if (next != Integer.MIN_VALUE && y[i] >= next) {
                break;
            }
            flag = true;
            max = Math.max(max, y[i]);
        }

        if (!flag) {
            System.out.println("NO");
        } else {
            x[index] = max;
            for (int i = 0; i < a1.length; i++) {
                if (i != 0) {
                    System.out.printf(" ");
                }
                System.out.print(x[i]);
            }
        }
    }
}
