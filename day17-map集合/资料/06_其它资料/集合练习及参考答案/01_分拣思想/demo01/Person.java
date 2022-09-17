package com.itheima.demo01;

public class Person extends Student {
   private String name;
   private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String no, double score, String name1) {
        super(name, no, score);
        this.name = name1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
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
