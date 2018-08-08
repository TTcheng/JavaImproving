package com.wangchuncheng.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Wangchuncheng on 2018/8/8 15:01
 */
//代理类
public class ProxyFactory implements InvocationHandler {
    Object object;

    //返回一个代理类对象
    public Object blind(Object o) {
        this.object = o;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object,args);
        return returnValue;
    }
}
