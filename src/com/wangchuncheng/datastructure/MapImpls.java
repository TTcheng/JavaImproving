package com.wangchuncheng.datastructure;

import com.wangchuncheng.designpattern.factorymethod.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Wangchuncheng on 2018/8/3 11:04
 * <p>
 * Map :其中key用set存储，因此不可重复，自定义key类型必须重写equals方法；value是Collection存储。
 * -- HashMap      -- LinkedHashMap(遍历较快，增加删除慢于HashMap)    HashMap和LinkedHashMap支持null键值
 * -- HashTable    -- Properties                                      HashTable不支持null键值
 * -- SortedMap    -- TreeMap(按照所添加元素的key的指定属性排序，其key必须是同一个类的对象)
 * :: put get remove containsKey containsValue
 */
public class MapImpls {
    @Test
    public void testHashMap() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        //添加
        hashMap.put("user", new User("1001","Jesse"));
        hashMap.put("class", MapImpls.class);
        hashMap.put("method", "MapImpls.testHashMap");
        //获取 hashMap.get("user");
        //遍历
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
        /*
        HashMap<User, String> userStringhashMap = new HashMap<User, String>();
        User jesse = new User("0001", "Jesse");
        User jessie = new User("0001", "Jessie");
        userStringhashMap.put(jesse, jesse.getName());
        userStringhashMap.put(jessie, jessie.getName());
        for (Map.Entry<User, String> entry : userStringhashMap.entrySet()) {
            System.out.println(entry);
        }
        */
    }
    @Test
    public void testTreeMap(){
        Map<Object,Object> map = new TreeMap<Object, Object>();
        map.put("user1",new User("1001","Jesse"));
        map.put(12,"Jessie");
        map.put("user3",new User("1003","Jessica"));
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}