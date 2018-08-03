package com.wangchuncheng.entity;

/**
 * Created by Wangchuncheng on 2018/8/3 14:06
 */
public class Dog {
    private String nickName;

    public Dog(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "nickName='" + nickName + '\'' +
                '}';
    }
}
