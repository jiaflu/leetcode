package com.jiaflu.producer_consumer;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列 BlockingQueue 的实现
 *
 * 被阻塞的情况：
 * - 当队列满了的时候进行入队操作
 * - 当队列空了的时候进行出队操作
 *
 * BlockingQueue 接口的一些方法：
 * - 操作	抛异常	    特定值	    阻塞	     超时
 * - 插入	add(o)	    offer(o)	put(o)	offer(o, timeout, timeunit)
 * - 移除	remove(o)	poll(o)	    take(o)	poll(timeout, timeunit)
 * - 检查	element(o)	peek(o)
 */

public class Test3 {

    private static Integer count = 0;
    // 创建一个阻塞队列
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();

    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
