package com.wangchuncheng.designpattern.factorymethod;

/**
 * Created by Wangchuncheng on 2018/8/3 10:05
 */
public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public User query(String id);
}
