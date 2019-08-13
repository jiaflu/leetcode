package com.jiaflu.thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("Runnable1");
        MyRunnable myRunnable2 = new MyRunnable("Runnable2");
        MyRunnable myRunnable3 = new MyRunnable("Runnable3");

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
