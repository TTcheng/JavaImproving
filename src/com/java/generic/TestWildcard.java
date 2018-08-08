package com.java.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangchuncheng on 2018/8/3 14:39
 * 通配符 ？
 * List<A> List<B> ....都是List<?>的子类
 */
public class TestWildcard {

    @Test
    public void testWildcard() {
        List<?> list;
        List<Object> objectList = new ArrayList<Object>();
        List<String> stringList = new ArrayList<String>();
        list = objectList;//可以赋值
        list = stringList;
        //objectList = stringList;//无法赋值，类型不兼容
        stringList.add("hello");
        stringList.add("Jesse");
        show(stringList);
    }

    public void show(List<?> list) {
        System.out.println("list = " + list);
    }
}
