package com.itheima.p6_generic_limit;

//Worker类
public class Worker extends Person {
    @Override
    public String toString() {
        return "Worker{" + "name='" + getName() + '\'' + ", age=" + getAge() + '}';
    }
    //根据父类生成空参,满参构造
    public Worker() {
    }

    public Worker(String name, int age) {
        super(name, age);
    }
}