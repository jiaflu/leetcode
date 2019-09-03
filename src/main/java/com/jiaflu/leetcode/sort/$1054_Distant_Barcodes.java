package com.jiaflu.leetcode.sort;

/**
 * 题目:距离相等的条形码
 *
 * 解答：思路很重要
 * - 首先统计每个数字出现的次数
 * - 从奇数位开始放置出现次数最多的数字
 * - 将其余数字放置在奇数位
 * - 将剩余数字放置在偶数位
 */

public class $1054_Distant_Barcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] count = new int[10001];
        // 统计每个数据的出现次数
        for (int i = 0; i < len; i++) {
            count[barcodes[i]]++;
        }
        // 得到出现次数最多的数字
        int maxCnt = 0;
        int maxNum = 0;
        for (int i = 1; i < 10001; i++) {
            if (count[i] > maxCnt) {
                maxCnt = count[i];
                maxNum = i;
            }
        }
        // 先填充奇数位
        int[] res = new int[len];
        int pos = 0; // result 填充位置
        int idx = 0; // count 填充位置
        while (pos < len) {
            if (count[maxNum] <= 0) {
                break;
            } else {
                count[maxNum]--;
                res[pos] = maxNum;
                pos += 2;
            }
        }
        // 继续填充奇数位
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                res[pos] = idx;
                pos += 2;
            }
        }
        // 继续填充偶数位
        pos = 1;
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                res[pos] = idx;
                pos += 2;
            }
        }
        return res;
    }
}
