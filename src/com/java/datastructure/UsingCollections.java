package com.java.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wangchuncheng on 2018/8/3 13:33
 * <p>
 * 可以操作实现Collection和Map的接口
 * 功能：sort排序，reverse倒置，swap交换，shuffle随机排序
 */
public class UsingCollections {

    List list = new ArrayList<String>();

    {
        list.add("Hello");
        list.add("Jesse");
        list.add("I'm");
        list.add("Baimax");
    }

    private void iterOut(){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void testSort() {
        Collections.sort(list);
        iterOut();
    }

    @Test
    public void testReverse() {
        Collections.reverse(list);
        iterOut();
    }

    @Test
    public void testSwap() {
        Collections.swap(list, 1, 3);
        iterOut();
    }
}
