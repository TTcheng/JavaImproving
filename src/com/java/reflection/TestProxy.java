package com.java.reflection;

import com.java.reflection.staticproxy.ClothFactory;
import com.java.reflection.staticproxy.NikeClothFactory;
import com.java.reflection.staticproxy.ProxyFactory;
import org.junit.Test;

/**
 * Created by Wangchuncheng on 2018/8/8 14:47
 * 反射应用之动态代理
 * 动态代理的好处是在运行时动态的创建代理对象，不需要为每个接口去编写单独的代理类
 */
public class TestProxy {
    @Test
    public void testStaticProxy() {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyFactory proxyFactory = new ProxyFactory(nikeClothFactory);
        proxyFactory.produce();
    }

    @Test
    public void testDynamicProxy() {
        //被代理对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance = (ClothFactory) new com.java.reflection.dynamicproxy.ProxyFactory().blind(nikeClothFactory);//返回代理对象
        proxyInstance.produce();
    }
}
