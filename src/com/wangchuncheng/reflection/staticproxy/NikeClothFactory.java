package com.wangchuncheng.reflection.staticproxy;

/**
 * Created by Wangchuncheng on 2018/8/8 14:59
 */
//被代理类
public class NikeClothFactory implements ClothFactory{
    @Override
    public void produce() {
        System.out.println("生产一件Nike衣服。。。");
    }
}
