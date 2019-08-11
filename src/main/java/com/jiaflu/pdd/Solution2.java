package com.jiaflu.pdd;

import java.util.*;

/**
 * 题目：
 * 判断字符串数组能否通过更换数组中元素的位置形成环
 *
 * 输入：
 * CAT TIGER RPC
 * 输出：true
 *
 * 输入：
 * CAT RPC
 * 输出：false
 *
 * 思路：
 * - 分别判断首位字符,首+尾-,看最后是否全部抵消
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] strings = a.split(" ");
        int[] chars = new int[27];
        int sum = 0;

        for (int i = 0; i < strings.length; i++) {
            int val = strings[i].charAt(0) - 'A';
            if (chars[val] == 0) {
                chars[val]++;
                sum++;
            } else {
                chars[val]--;
                sum--;

            }

            val = strings[i].charAt(strings[i].length()-1) - 'A';
            if (chars[val] == 0) {
                chars[val]++;
                sum++;
            } else {
                chars[val]--;
                sum--;

            }
        }
        if(sum!=0){
            System.out.println("false");
        }else{
            System.out.println("true");
        }

    }
}
