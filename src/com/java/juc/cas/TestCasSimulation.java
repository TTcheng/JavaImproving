package com.java.juc.cas;

import org.junit.Test;

/**
 * Created by Wangchuncheng on 2018/8/21 12:14
 */
public class TestCasSimulation {
    private static final CompareAndSwap cas = new CompareAndSwap();

    @Test
    public void test() throws InterruptedException {
        System.out.println("initialValue = " + cas.getValue());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.getValue();
                int newValue = (int) (Math.random() * 101);
                boolean setSuccess = cas.compareAndSet(expectedValue, newValue);
                if (setSuccess) {
                    System.out.println("修改为" + newValue);
                } else System.out.println("修改失败！");
            }).start();
        }
        Thread.sleep(10);
        System.out.println("finalValue = " + cas.getValue());
    }
}
