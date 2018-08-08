package com.java.designpattern.proxy;

/**
 * Created by Wangchuncheng on 2018/8/3 10:20
 *
 * 接口应用之代理模式
 */
public class Main {
    public static void main(String[] args) {
        Proxable proxy = new ProxableImpl();//被代理对象
        ProxyObject proxyObject = new ProxyObject(proxy);//代理对象
        proxyObject.proxy();//代理执行
    }
}
