package com.jiaflu.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> ft = newCachedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        if (!ft.isDone()) {
            System.out.println("task has not finished, please wait!");
        }
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            // attention
            newCachedThreadPool.shutdown();
        }
    }

}
