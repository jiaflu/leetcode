package com.jiaflu.javabasic.reflect;

public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        //ClassLoader cl = Robot.class.getClassLoader();
        Class c = Class.forName("com.jiaflu.javabasic.reflect.Robot");
    }
}
