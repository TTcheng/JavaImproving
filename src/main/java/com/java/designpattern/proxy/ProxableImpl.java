package com.java.designpattern.proxy;

/**
 * Created by Wangchuncheng on 2018/8/3 10:19
 *
 * 被代理对象
 */
public class ProxableImpl implements Proxable {
    @Override
    public void proxy() {
        System.out.println("被代理内容");
    }
}
