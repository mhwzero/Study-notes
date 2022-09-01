package com.itheima.p7_extends_test;

/*
    定义父类员工Employee07类
        1.成员变量必须使用private修饰
        2.提供空参构造/满参构造
        3.提供get/set方法
 */
public class Employee07 /*extends Object*/ {
    //成员变量
    //1.成员变量必须使用private修饰
    private String name;//姓名
    private int age;//年龄
    private int salary;//薪资

    //2.提供空参构造
    public Employee07() {
    }

    //2.提供满参构造
    public Employee07(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //成员方法
    public void showInfo() {
        System.out.println("姓名: " + name + ", 年龄: " + age + ", 薪资: " + salary);
    }

    //3.提供get/set方法
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
