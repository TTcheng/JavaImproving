package com.java.juc.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Wangchuncheng on 2018/8/21 14:43
 * <p>
 * Callable相较于Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 * 需要FutureTask实现类的支持，用于接收运算结果。
 */
public class TestCallable {
    public static void main(String[] args) {
        CallableDemo td = new CallableDemo();
        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();
        try {
            /* 这里会等到上面的线程执行完毕时再执行。即可用于闭锁 */
            Integer sum = result.get();
            System.out.println("sum = " + sum);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
