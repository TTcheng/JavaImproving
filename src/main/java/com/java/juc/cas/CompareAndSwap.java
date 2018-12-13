package com.java.juc.cas;

/**
 * Created by Wangchuncheng on 2018/8/21 12:15
 * CVS模拟实现，这里使用synchronized，JUC里面并不是这样
 */
class CompareAndSwap {
    private int value = 0;

    //获取
    synchronized int getValue() {
        return value;
    }

    //比较
    private synchronized int compareAndSwap(int oldValue, int newValue) {
        int currentValue = getValue();
        if (oldValue == currentValue) {
            this.value = newValue;
        }
        return currentValue;
    }

    //设置
    synchronized boolean compareAndSet(int oldValue, int newValue) {
        return oldValue == compareAndSwap(oldValue, newValue);
    }
}
