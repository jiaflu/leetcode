package com.jiaflu.design_pattern;

/**
 * 单例模式
 * - 饿汉模式：指全局的单例实例在类装载时构建
 * - 懒汉模式：指全局的单例实例在第一次被使用时构建
 */

// 饿汉模式(线程安全)
//public class Singleton {
//    private static Singleton uniqueInstance = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance() {
//        return uniqueInstance;
//    }
//}

// 懒汉模式
public class Singleton {
    //volatile 禁止指令重排，打乱3 4 的步骤
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getInstance() {
        if (uniqueInstance == null) { // 1 加锁比较消耗资源，此处的判断是为了减少资源的消耗
            synchronized (Singleton.class) { // 2
                if (uniqueInstance == null) { // 3,若没有此步骤，等待锁的线程拿到锁后会再次创建实例
                    uniqueInstance = new Singleton(); // 4
                }
            }
        }
        return uniqueInstance;
    }
}
/**
 * https://www.jianshu.com/p/35e4504d42e4
 */
