package com.jiaflu.huawei;

import java.util.Scanner;

/**
 * 合唱队
 */

public class HW019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(countChorus(arr));
        }

        scanner.close();
    }

    /**
     * <pre>
     * 解题思路
     * 乍一看这道题好像无从下手？难不成要枚举出所有的情况才能得出结果。一般来说是不会有那种枚举所有情况的题的。
     * 实际上这是一道简单动态规划的题。但是一眼看上去不是很直观。题目所谓的合唱队形就是一个最长上升子序列的拼接。
     * 只要求出从队列首到位置 i 的最长上升子序列长度加上从队尾开始到位置 i 的最长上升子序列的长度就能求出合唱队
     * 形的总长度。 我们还知道总的人数，减一下就能得出要出列的人数了。
     *
     * 求最长上升子序列
     * 现在有一个序列，要求他的最长上升子序列。直观上并不是很好求得，反过来看的话就能比较好理解：
     * 现在对于总序列里的第i个元素来说，包含元素i的最长子序列是多少呢？如果i前面有能构成最长上升序列的（设它为j），
     * 而且i数值比j大，那很显然到第i个元素(包含元素i)的最长子序列是到第j个元素的最长子序列+1；否则到第i个元素
     * (包含元素i)的最长子序列就是是1。因为前面没有比他更小的了，只有自身构成一个子序列。
     * </pre>
     */

    private static String countChorus(int[] arr) {
        return null;
    }
}
