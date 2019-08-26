package com.jiaflu.javabasic.reflect;

import java.util.LinkedList;

public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("C:\\Users\\jiaflu\\workspace\\leetcode\\src\\main\\java\\com\\jiaflu\\javabasic\\reflect\\", "myClassLoader");
        Class c = m.loadClass("Wali");
        // 双亲委派模型厕所
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        c.newInstance();
    }
}
