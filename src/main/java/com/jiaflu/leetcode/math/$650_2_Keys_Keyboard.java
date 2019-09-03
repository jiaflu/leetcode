package com.jiaflu.leetcode.math;

/**
 * 题目：只有两个键的键盘
 *
 * 解答：
 * - n>1 时,其实就是将 n 分解为 m 个数字的乘积;
 * - 且 m 个数字的和最小,即把一个数分解为 n 个质数的和 从小到大的去试探
 */

public class $650_2_Keys_Keyboard {

    // 规律
    public static int minSteps_(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }




    // DFS 超时
    static int res;
    public static int minSteps(int n) {
        res = Integer.MAX_VALUE;
        if (n <= 1) {
            return 0;
        }
        dfs("A", "A", n, 1);
        return res;
    }
    private static void dfs(String str, String copy, int n, int cnt) {
        if (str.length() > n) {
            return;
        }
        if (str.length() == n) {
            if (res > cnt) {
                res = cnt;
            }
            return;
        }
        if (cnt > res) {
            return;
        }
        dfs(str+copy, copy, n, cnt+1);
        dfs(str+str, str, n, cnt+2);
    }

    public static void main(String[] args) {
        System.out.println(minSteps(11));
        System.out.println(minSteps_(11));
    }
}
