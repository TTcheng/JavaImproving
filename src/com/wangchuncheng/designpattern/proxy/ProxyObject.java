package com.wangchuncheng.designpattern.proxy;

/**
 * Created by Wangchuncheng on 2018/8/3 10:18
 *
 * 代理对象
 */
public class ProxyObject implements Proxable {
    private Proxable obj;

    public ProxyObject(Proxable obj) {
        this.obj = obj;
    }

    @Override
    public void proxy() {
        System.out.println("=========开始代理========");
        obj.proxy();
        System.out.println("=========结束代理========");
    }
}
