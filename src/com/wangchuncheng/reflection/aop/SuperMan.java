package com.wangchuncheng.reflection.aop;

/**
 * Created by Wangchuncheng on 2018/8/8 15:36
 */
public class SuperMan implements Walkable, Flyable {

    @Override
    public void walking() {
        System.out.println("=====walking=====");
    }

    @Override
    public void flying() {
        System.out.println("=====flying=====");
    }
}
