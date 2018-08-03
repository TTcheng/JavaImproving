package com.wangchuncheng.designpattern;

/**
 * Created by Wangchuncheng on 2018/8/3 9:57
 */
public class SingleInstance {
    public static SingleInstance instance = new SingleInstance();

    public static SingleInstance getInstance() {
        return instance;
    }
}
