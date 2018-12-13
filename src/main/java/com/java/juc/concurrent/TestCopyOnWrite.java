package com.java.juc.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Wangchuncheng on 2018/8/21 14:04
 */
public class TestCopyOnWrite {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }
}
class HelloThread implements Runnable {
    //将抛出同步修改异常
//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    //同步数据结构
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        for (String s : list) {
            System.out.println(s);
            list.add("AA");
        }
    }
}