package com.jiaflu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：乘法表中第k小的数
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 *
 * 解答：
 * - 二分查找
 */

public class $668_Kth_Smallest_Number_in_Multiplication_Table {

    public static int findKthNumber(int n, int m, int k) {
        int left = 1, right = n * m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = smallNumCount(n, m, mid);//计算乘法表中不大于mid的元素个数
            if (cnt >= k){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return left;
    }

    //在m，n的乘法表中，寻找不大于num的元素个数
    private static int smallNumCount(int n, int m, int mid) {
        int count = 0;
        //对乘法表的每一行（每一行都是递增）进行搜索，nums[row][col] = row * col
        for (int i = 1; i <= n; i++) {
            count += Math.min(mid/i, m);// mid/i代表的是如果mid也在第i行，它存在的列数，而一行最多只有n个
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(findKthNumber(3,3,5));
    }
}
