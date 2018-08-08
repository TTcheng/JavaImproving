package com.wangchuncheng.reflection.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Wangchuncheng on 2018/8/8 15:39
 */
public class MyInvocationHandler implements InvocationHandler {
    Object target;//被代理对象

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ManUtils.method1();
        Object returnValue = method.invoke(target,args);
        ManUtils.method2();
        return returnValue;
    }
}
