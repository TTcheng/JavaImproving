package com.wangchuncheng.datastructure;

import java.util.HashSet;

/**
 * Created by Wangchuncheng on 2018/8/3 10:41
 *
 * Collection 有很多子接口和实现类
 *
 * Collection
 *      -- List
 *             -- ArrayList LinkedList（适合频繁的插入和删除） Vector(线程安全，效率低) ...
 *      -- Set  无序存储。不可重复
 *             -- HashSet(HashMap的一个实现) LinkedHashSet（维护了添加顺序，迭代性能高，插入性能略低） TreeSet（只能存储同一个类的对象，根据包含对象的comparable接口指定的顺序遍历）...
 *      -- Queue
 *             --BlockIngQueue:  LinkedBlockingQueue ArrayBlockingQueue ...
 */
public class CollectionImpls {
    public static void main(String[] args) {
        new HashSet<Object>();
    }
}
