package com.java.reflection.staticproxy;

/**
 * Created by Wangchuncheng on 2018/8/8 15:01
 */
//代理类
public class ProxyFactory implements ClothFactory {
    ClothFactory clothFactory;

    public ProxyFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produce() {
        System.out.println("=============开始代理================");
        clothFactory.produce();
        System.out.println("=============结束代理================");
    }
}
