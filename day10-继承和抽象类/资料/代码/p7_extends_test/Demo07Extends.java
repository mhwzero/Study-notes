package com.itheima.p7_extends_test;

public class Demo07Extends {
    public static void main(String[] args) {
        //创建子类对象: 空参构造方法
        Teacher07 t = new Teacher07();

        //调用set方法给成员变量赋值
        t.setName("响哥哥");
        t.setAge(18);
        t.setSalary(66666);

        //调用成员方法
        t.showInfo();
        t.teaching();

        System.out.println("---------");

        //创建子类对象: 满参构造方法
        Manager07 m = new Manager07("宾哥哥", 16, 88888);

        //调用成员方法
        m.showInfo();
        m.managerClass();
    }
}
