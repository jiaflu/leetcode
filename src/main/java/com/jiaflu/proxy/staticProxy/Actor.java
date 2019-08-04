package com.jiaflu.proxy.staticProxy;

/**
 * 真实实体类
 */

public class Actor implements Person {
    private String content;

    public Actor(String content) {
        this.content = content;
    }

    @Override
    public void speak() {
        System.out.println(this.content);
    }
}
