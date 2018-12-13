package com.java.juc.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Wangchuncheng on 2018/8/21 15:09
 */
public class TestLock {
    public static void main(String[] args) {
        TicketSeller ticketSeller = new TicketSeller();
        new Thread(ticketSeller, "1号窗口").start();
        new Thread(ticketSeller, "2号窗口").start();
        new Thread(ticketSeller, "3号窗口").start();
    }
}

class TicketSeller implements Runnable {
    private int tickets = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();//上锁
            try {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为:" + --tickets);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
