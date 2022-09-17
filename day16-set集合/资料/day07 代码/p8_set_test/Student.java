package com.itheima.p8_set_test;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    //存储HashSet集合保证元素唯一,必须覆盖重写hashCode和equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        boolean result = age == student.age && Objects.equals(name, student.name);
        System.out.println(this.name + "...equals...." + student.name + "...结果: " + result);
        return result;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(name, age);
        System.out.println("计算出 " + this.name + " 的哈希值: " + hash);
        return hash;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
