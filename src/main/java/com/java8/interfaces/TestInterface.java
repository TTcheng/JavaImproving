package com.java8.interfaces;

import org.junit.Test;

/**
 * Created by Wangchuncheng on 2018/8/20 16:13
 * Java8中接口允许定义具有实现的方法。
 * 1、默认方法
 * 冲突：
 * ①与类实现方法冲突。类优先方法
 * ②与接口方法/类抽象方法冲突。必须实现该方法
 * 2、静态方法
 * 同类的静态方法。
 */
public class TestInterface implements Java8Interface {
    @Test
    public void testMethod() {
        //接口的默认方法
        defaultMethod();
        //接口的静态方法
        Java8Interface.staticMethod();
    }

    /**
     * 类优先法则 ，类中的方法会覆盖同名的默认接口方法
     * @return
     */
//    public String getName(){
//        return "Hello class";
//    }
}
