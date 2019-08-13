package com.jiaflu.leetcode.binarySearch;

/**
 * 题目：H指数 II
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 *
 *  
 *
 * 示例:
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *
 * 解答：
 *
 *
 */

public class $275_H_Index_II {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 以[0,1,3,5,6]为例.
            // 假如当前 引用次数 = 1,即1篇至少1个引用,事实上有4篇至少1个引用,所以往后找,故left = mid+1.
            // 假如当前 引用次数 = 5,即5篇至少5个引用,事实上只有2篇至少5个引用,只能往前找,故right = mid.
            // 注意: assume == actual的时候要保留mid,所以放在了right = mid的分支.
            int assume = citations[mid];
            int actual = len - mid;

            if (assume < actual) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }
}
