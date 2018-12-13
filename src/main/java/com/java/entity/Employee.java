package com.java.entity;

/**
 * Created by Wangchuncheng on 2018/8/15 15:32
 */
public class Employee extends Person {
    private Double salary;
    private Status status;

    public Employee(String name, Integer age,Double salary, Status status) {
        super(name, age);
        this.salary = salary;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

