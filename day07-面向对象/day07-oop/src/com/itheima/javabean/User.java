package com.itheima.javabean;

public class User {
    // 1.成员属性使用private私有化
    private String name;
    private int age;
    private double height;
    private double salary;

    // 3.必须提供无参数构造器，有参数构造器是可选的，但是一旦写了有参数构造器，必须把无参数构造器写出来
    public User() {
    }

    public User(String name, int age, double height, double salary) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.salary = salary;
    }


    // 2.提供成对的getter和setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
