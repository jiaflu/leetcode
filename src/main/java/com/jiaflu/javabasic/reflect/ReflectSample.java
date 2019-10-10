package com.jiaflu.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("com.jiaflu.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        //Class rc = r.getClass();
        System.out.println("Class name is " + rc.getName());
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        // throwHello 为 private 方法
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "Bob");
        System.out.println("getHello result is " + str);

        Method sayHi = rc.getMethod("sayHi", String.class);
        Object sss = sayHi.invoke(r, "Welcome");

        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alice");
        sayHi.invoke(r, "Welcome");

        Object a = "sadsa";
        System.out.println(a);

    }

}
