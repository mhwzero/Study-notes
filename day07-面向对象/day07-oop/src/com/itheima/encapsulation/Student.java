package com.itheima.encapsulation;

public class Student {
    // 1.将成员变量使用private修饰私有化
    private int age;

    // 2.必要的时候提供成对的public修饰的getter、setter方法
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("您输入的年龄数据有误");
        }
    }
}
