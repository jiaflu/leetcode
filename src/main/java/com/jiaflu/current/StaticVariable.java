package com.jiaflu.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StaticVariable {
    static int n = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(()-> {
                n++;
            });
        }
        executorService.shutdown();
        System.out.println(n);
    }
}
