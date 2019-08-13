package com.jiaflu.thread;

public class ThreadTest {
    private static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread is : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                attack();
            }
        };
        System.out.println("current main thread is : " + Thread.currentThread().getName());
        t.start();

        // 阻塞当前线程以等待子线程处理完毕
        // block the current thread until it has been finished
        t.join();

        // 线程运行结束后不会再通过 start 启动
        // after the thread is completed, it can not be run again through start()
        t.start();
    }
}
