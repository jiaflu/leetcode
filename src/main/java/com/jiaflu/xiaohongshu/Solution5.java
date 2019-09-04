package com.jiaflu.xiaohongshu;

import java.util.Scanner;

/**
 * 迷宫问题
 */

public class Solution5 {
    static int min;
    public static void main(String[] args) {
        min = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        int sa=0, sb=0, ea=0, eb=0;
        char[][] arr = new char[n][n];
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[i][j] = c;
                if (c == 'S') {
                    sa = i;
                    sb = j;
                }
                if (c == 'E') {
                    ea = i;
                    eb = j;
                }
            }
        }
        search(arr, flag, 0, sa, sb, ea, eb);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        //System.out.println("sa");
    }

    private static void search(char[][] arr, boolean[][] flag, int count, int a, int b, int ea, int eb) {
        if (a == ea && b == eb) {
            if (min > count) {
                min = count;
            }
            return;
        }
        if (count >= min) {
            return;
        }

        if (a+1 == arr.length) {
            int tmpA = a, tmpB = b;
            tmpA = 0;
            if (flag[tmpA][tmpB] == false && arr[tmpA][tmpB] != '#') {
                flag[tmpA][tmpB] = true;
                search(arr, flag, count+1, tmpA, tmpB, ea, eb);
                flag[tmpA][b] = false;
            }
        } else {
            if (flag[a+1][b] == false && arr[a+1][b] != '#') {
                flag[a+1][b] = true;
                search(arr, flag, count+1, a+1, b, ea, eb);
                flag[a+1][b] = false;
            }
        }

        if (b+1 == arr.length) {
            int tmpA = a, tmpB = b;
            tmpB = 0;
            if (flag[tmpA][tmpB] == false && arr[tmpA][tmpB] != '#') {
                flag[tmpA][tmpB] = true;
                search(arr, flag, count+1, tmpA, tmpB, ea, eb);
                flag[tmpA][b] = false;
            }
        } else {
            if (flag[a][b+1] == false && arr[a][b+1] != '#') {
                flag[a][b+1] = true;
                search(arr, flag, count+1, a, b+1, ea, eb);
                flag[a][b+1] = false;
            }
        }

        if (a-1 == -1) {
            int tmpA = a, tmpB = b;
            tmpA = arr.length-1;
            if (flag[tmpA][tmpB] == false && arr[tmpA][tmpB] != '#') {
                flag[tmpA][tmpB] = true;
                search(arr, flag, count+1, tmpA, tmpB, ea, eb);
                flag[tmpA][b] = false;
            }
        } else {
            if (flag[a-1][b] == false && arr[a-1][b] != '#') {
                flag[a-1][b] = true;
                search(arr, flag, count+1, a-1, b, ea, eb);
                flag[a-1][b] = false;
            }
        }

        if (b-1 == -1) {
            int tmpA = a, tmpB = b;
            tmpB = arr.length-1;
            if (flag[tmpA][tmpB] == false && arr[tmpA][tmpB] != '#') {
                flag[tmpA][tmpB] = true;
                search(arr, flag, count+1, tmpA, tmpB, ea, eb);
                flag[tmpA][b] = false;
            }
        } else {
            if (flag[a][b-1] == false && arr[a][b-1] != '#') {
                flag[a][b-1] = true;
                search(arr, flag, count, a, b-1, ea, eb);
                flag[a][b-1] = false;
            }
        }
        return;
    }
}
