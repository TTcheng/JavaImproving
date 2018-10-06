package com.java.juc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Wangchuncheng on 2018/8/21 14:17
 * CountDownLatch闭锁
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final int threadNum = 5;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        LatchDemo latchDemo = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(latchDemo).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //等其他线程执行完毕时才执行下面的语句
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            latch.countDown();//倒计时减一
        }
    }
}
