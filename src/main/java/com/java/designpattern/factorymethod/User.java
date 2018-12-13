package com.java.designpattern.factorymethod;

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

    /**
     * 重写equals方法时必须要重写hashCode方法，否则map会将equal的对象当做不同的对象而允许插入
     * @param obj
     * @return
     */
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

    /**
     * 注意：当equals方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，
     * 该协定声明相等对象必须具有相等的哈希码。如下：
     * (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true
     * (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }
}
