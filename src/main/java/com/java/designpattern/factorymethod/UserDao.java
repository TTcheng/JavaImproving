package com.java.designpattern.factorymethod;

/**
 * Created by Wangchuncheng on 2018/8/3 10:05
 */
public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(User user);
    User query(String id);
}
