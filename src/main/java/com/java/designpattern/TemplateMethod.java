package com.java.designpattern;

/**
 * Created by Wangchuncheng on 2018/8/3 9:50
 * 模板方法模式：抽象方法
 */
public class TemplateMethod {
    public static void main(String[] args) {
        new SubTemplate().spendtime();
    }
}

abstract class Template {
    protected abstract void code();

    /**
     * 计算code方法执行时间
     */
    void spendtime() {
        long startTime = System.currentTimeMillis();
        code();
        long endTime = System.currentTimeMillis();
        System.out.println("Spend Time:" + (endTime - startTime) + "ms");
    }
}

class SubTemplate extends Template {

    @Override
    protected void code() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {

            }
        }
    }
}