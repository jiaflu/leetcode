package com.jiaflu.leetcode.String;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 解答：
 * - 切分字符串处理
 */

public class $71_Simplify_Path {
    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> list = new LinkedList<>();
        list.add("/");
        for (int i = 0; i < strs.length; i++) {
            if ("".equals(strs[i]) || ".".equals(strs[i]) || strs[i] == null) {
                continue;
            } else if ("..".equals(strs[i])) {
                if (list.size() < 2) {
                    continue;
                }
                list.remove(list.size()-1);
                list.remove(list.size()-1);

            } else {
                list.add(strs[i]);
                list.add("/");
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <list.size()-1; i++) {
            builder.append(list.get(i));
        }
        if (list.size() <= 1) {
            builder.append("/");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        simplifyPath(path);
    }
}
