package com.jiaflu.leetcode.stack;

import java.util.LinkedList;

/**
 * 题目：字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 解答：
 * - 栈
 * 构建辅助栈stack, 遍历字符串s中每个字符c；
 *  - 当c为数字时，将数字字符转化为数字multi，用于后续倍数计算；
 *  - 当c为字母时，在res尾部添加c；
 *  - 当c为[时，将当前multi和res入栈，并分别置空置 00：
 *    - 记录此[前的临时结果res至栈，用于发现对应]后的拼接操作；
 *    - 记录此[前的倍数multi至栈，用于发现对应]后，获取multi × [...]字符串。
 *    - 进入到新[后，res和multi重新记录。
 *  - 当c为]时，stack出栈，拼接字符串res = last_res + cur_multi * res:
 *    - last_res是上个[到当前[的字符，例如"3[a2[c]]"中的a；
 *    - cur_multi是当前[到]内字符的倍数，例如"3[a2[c]]"中的2。
 *  - 返回字符串res。
 *
 *
 *
 */

public class $394_Decode_String {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("leetcode"));
        //System.out.println(Math.pow(10, 0));
    }
}
