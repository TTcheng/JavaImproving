package com.wangchuncheng.reflection.aop;

import java.lang.reflect.Proxy;

/**
 * Created by Wangchuncheng on 2018/8/8 15:46
 * 动态的创建代理类对象
 */
public class MyProxy {
    public static Object getProxyInstance(Object target) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
    }
}
