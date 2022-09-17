package com.itheima.p6_generic_limit;

//JavaTeacher类
public class JavaTeacher extends Teacher {
    @Override
    public String toString() {
        return "JavaTeacher{" + "name='" + getName()+'\'' + ", age=" + getAge() + '}';
    }
    //根据父类生成空参,满参构造

    public JavaTeacher() {
    }

    public JavaTeacher(String name, int age) {
        super(name, age);
    }
}