package com.java.reflection;

import com.java.reflection.aop.Flyable;
import com.java.reflection.aop.MyProxy;
import com.java.reflection.aop.SuperMan;
import com.java.reflection.aop.Walkable;
import org.junit.Test;

/**
 * Created by Wangchuncheng on 2018/8/8 15:33
 */
public class TestAop {
    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        Object proxyInstance = MyProxy.getProxyInstance(superMan);

        Flyable flyable = (Flyable) proxyInstance;
        flyable.flying();

        System.out.println();

        Walkable walkable = (Walkable) proxyInstance;
        walkable.walking();
    }
}
