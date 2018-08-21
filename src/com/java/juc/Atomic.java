package com.java.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**********************************************************************************************************************
 * Created by WangChuncheng on 2018/7/7 13:56.
 **********************************************************************************************************************
 * 一、原子性：即不可分割的步骤
 * 二、i++的原子问题
 * int i=10;   i = i++;//最后，i=10
 * 实际执行顺序：int temp = i;   i = i+1;    i = temp;
 * 三、原子变量：java.util.concurrent.atomic包提供了常用的原子变量：如AtomicInteger、AtomicBoolean、AtomicReference<E>
 * 这些变量都是通过volatile + CAS算法实现的
 **********************************************************************************************************************
 * CAS：Compare And Swap
 * 举例：当线程修改某个变量之前先读取这个变量的值(假设为A)，修改预期值为V，而运算完后即将写入主
 * 存变量时再次读取变量(假设此时为B)，当A==B时，提交新值V，否则放弃此次修改，重新开始。
 **********************************************************************************************************************
 * 使用原子变量解决了原子性问题，同时又比使用synchronized的效率高得多
 *********************************************************************************************************************/
public class Atomic {
    public static void main(String[] args) throws InterruptedException {
        //使用普通变量，可能(原子问题不是每次都出现)会出现相同值
        AtomicUnsatisfied au = new AtomicUnsatisfied();
        for (int i = 0; i < 10; i++) {
            new Thread(au).start();
        }
        //将两种线程分开
        Thread.sleep(200);
        System.out.println("====================");
        //使用原子变量的，一定不会出现相同值
        AtomicSatisfied as = new AtomicSatisfied();
        for (int i = 0; i < 10; i++) {
            new Thread(as).start();
        }
    }
}

/**
 * 使用AtomicInteger
 */
class AtomicSatisfied implements Runnable {
    private AtomicInteger num = new AtomicInteger(0);

    private int getNum() {
        return num.getAndAdd(1);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + getNum());
    }
}

/**
 * 变量num不满足原子性，当多个线程同时操作num时，可能会出现问题。
 */
class AtomicUnsatisfied implements Runnable {
    private int num = 0;

    private int getNum() {
        return num++;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + getNum());
    }
}
