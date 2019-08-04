package com.jiaflu.proxy.dynamicProxy.jdk;

/**
 * Apple 实现 Fruit 接口
 */

public class Apple implements Fruit {
    @Override
    public void show() {
        System.out.println("<<<<show method is invoked");
    }

    @Override
    public void eat() {
        System.out.println("<<<<eat method is invoked");
    }
}
