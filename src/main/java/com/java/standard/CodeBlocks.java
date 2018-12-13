package com.java.standard;

/**
 * Created by Wangchuncheng on 2018/8/3 9:24
 *
 * 非静态代码块和显示的初始化按出现的先后顺序执行，他们都在构造方法之前，并且每次实例化都会执行
 *
 * 静态代码块在类加载时执行，早于非静态内容执行，并且整个应用生命周期只执行一次
 */
public class CodeBlocks {

    //显示的初始化
    private String name;
    {
        name = "jessica";
        System.out.println("CodeBlocks.instance initializer 非静态代码块");
    }
    static {
        System.out.println("CodeBlocks.static initializer 静态代码块");
    }

    //构造方法是创建对象的最后一道关口
    private CodeBlocks() {
        System.out.println("CodeBlocks.CodeBlocks 构造方法");
    }

    @Override
    public String toString() {
        return "CodeBlocks{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("===========================start of main");
        CodeBlocks codeBlocks = new CodeBlocks();
        System.out.println("codeBlocks = " + codeBlocks);
        System.out.println("===========================");
        CodeBlocks codeBlocks1 = new CodeBlocks();
        System.out.println("codeBlocks1 = " + codeBlocks1);
        System.out.println("===========================end of main");
    }
}
