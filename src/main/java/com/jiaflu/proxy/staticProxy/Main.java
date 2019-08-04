package com.jiaflu.proxy.staticProxy;

/**
 * 测试类
 */
public class Main {
    public static void main(String[] args) {
        Actor actor = new Actor("I am a famous actor!");
        Agent agent = new Agent(actor, "Hello, I am an agent.", "That's all!");
        agent.speak();
    }
}
