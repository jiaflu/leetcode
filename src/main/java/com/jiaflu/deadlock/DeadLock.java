package com.jiaflu.deadlock;

/**
 * 一个死锁的例子
 */

public class DeadLock {

    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.setDeadlock();
    }

    private void setDeadlock() {
        Thread A = new Thread() {
            @Override
            public void run() {
                threadA();
            }
        };
        Thread B = new Thread() {
            @Override
            public void run() {
                threadB();
            }
        };
        A.start();
        B.start();
    }

    protected void threadA() {
        synchronized (DeadLock.a) {
            System.out.println("A keeps a");
            sleep();  // 留出时间让线程B去锁住b
            synchronized (DeadLock.b) {
                System.out.println("A got b");
                sleep();
            }

        }
    }

    protected void threadB() {
        synchronized (DeadLock.b) {
            System.out.println("B keeps b");
            sleep();
            synchronized (DeadLock.a) {
                System.out.println("B got a");
                sleep();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
