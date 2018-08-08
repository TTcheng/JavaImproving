package com.wangchuncheng.reflection;

import com.wangchuncheng.reflection.aop.Flyable;
import com.wangchuncheng.reflection.aop.MyProxy;
import com.wangchuncheng.reflection.aop.SuperMan;
import com.wangchuncheng.reflection.aop.Walkable;
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
