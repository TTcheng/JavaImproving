package com.wangchuncheng.designpattern.factorymethod;

/**
 * Created by Wangchuncheng on 2018/8/3 10:05
 */
public class User implements Comparable<User> {
    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            return this.id.equals(((User) obj).id);
        }
        return false;
    }

    @Override
    public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }
}
