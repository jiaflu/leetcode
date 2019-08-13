package com.jiaflu.thread;

public class StringBufferWithoutSync {
    // StringBuffer 是线程安全,由于 sb 只会在 append 方法中使用,不可能被其他线程引用
    // 因此 sb 属于不可能共享的资源,JVM 会自动消除内部的锁
    public void add(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }

    public static void main(String[] args) {
        StringBufferWithoutSync withoutSync = new StringBufferWithoutSync();
        for (int i = 0; i < 1000; i++) {
            withoutSync.add("aa", "bb");
        }
    }
}
