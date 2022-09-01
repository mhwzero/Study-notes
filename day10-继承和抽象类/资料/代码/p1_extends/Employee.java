package com.itheima.p1_extends;

//定义父类员工Employee类
public class Employee {
    //成员变量
    String name;//姓名
    int age;//年龄
    int salary;//薪资

    //成员方法
    public void showInfo() {
        System.out.println("姓名: " + name + ", 年龄: " + age + ", 薪资: " + salary);
    }
}
