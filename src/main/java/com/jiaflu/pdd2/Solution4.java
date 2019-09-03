package com.jiaflu.pdd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 一个矩阵，有m行，n列，每个元素的值为该元素所在值x元素所在列，求矩阵中第k大的元素
 * 3 3 4
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * 输出 4
 *
 * leetcode 668
 *
 * 二分法
 *
 *
 */

public class Solution4 {

    public static int findKthNumber(int n, int m, int k) {
        int left = 1, right = n * m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = smallNumCount(n, m, mid);//计算乘法表中不大于mid的元素个数
            if ((n*m-cnt) >= k){
                left = mid + 1;
            }
            else{
                right = mid;
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
        System.out.println(findKthNumber(3,3,4));
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(); // 行
//        int m = in.nextInt(); // 列
//        int k = in.nextInt();
//        int[] arr = new int[m];
//        for (int i = 0; i < m; i++) {
//            arr[i] = i+1;
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < m; j++) {
//                list.add(arr[j] * i);
//            }
//        }
//        list.sort(((o1, o2) -> o2-o1));
//        System.out.println(list.get(k-1));
//    }
}
