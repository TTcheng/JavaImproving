package com.java8.interfaces;

/**
 * Created by Wangchuncheng on 2018/8/20 16:11
 */
public interface Java8Interface {
    default void defaultMethod() {
        System.out.println("Hello interface default method");
    }

    static void staticMethod() {
        System.out.println("Hello static interface method");
    }
}
