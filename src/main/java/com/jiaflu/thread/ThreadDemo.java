package com.jiaflu.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread myThread1 = new MyThread("t1");
        Thread myThread2 = new MyThread("t2");
        Thread myThread3 = new MyThread("t3");
        Thread myThread4 = new MyThread("t4");
        Thread myThread5 = new MyThread("t5");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }

}
