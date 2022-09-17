package com.itheima.p6_generic_limit;

//Teacher类
public class Teacher extends Worker {
    @Override
    public String toString() {
        return "Teacher{" + "name='" + getName() + '\'' + ", age=" + getAge() + '}';
    }
    //根据父类生成空参,满参构造

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }
}