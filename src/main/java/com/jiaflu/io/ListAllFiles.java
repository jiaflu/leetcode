package com.jiaflu.io;

import java.io.File;

/**
 * 递归出一个目录下的所有文件
 */

public class ListAllFiles {

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\jiaflu\\workspace\\leetcode\\src\\main\\java\\com\\jiaflu\\io");
        listAllFiles(dir);
    }
}
