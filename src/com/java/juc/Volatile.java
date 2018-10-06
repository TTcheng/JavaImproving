package com.java.juc;

/**********************************************************************************************************************
 * Created by WangChuncheng on 2018/7/7 13:33.
 * volatile关键字解决了内存可见性的问题
 * 内存可见性问题：当多个线程操作共享数据时，操作时在各自的缓存区进行，操作结束后再反馈到主存中，因此造成了各个线程之间
 * 彼此内存不可见。
 **********************************************************************************************************************
 * volatile 和 synchronized的区别：
 *      volatile只解决了内存可见性问题，但不具有原子性和互斥性
 *      synchronized同时解决了内存可见性，也具有原子性和互斥性，但是程序执行效率比volatile低得多
 *********************************************************************************************************************/
public class Volatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        Thread thread1 = new Thread(td);
        thread1.start();
        while (true){
            //main线程和thread1共享td.flag
            if (td.isFlag()){
                //当flag没有volatile关键字修饰时，这个输出语句始终不会被打印，这就是由内存不可见造成的
                //当flag由volatile修饰时，当flag=true时，下面的语句将立即执行。
                System.out.println("================");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
//    private boolean flag = false;
    private volatile boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }
}