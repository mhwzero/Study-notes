package com.itheima.p1_extends;

//定义子类讲师Teacher类
public class Teacher extends Employee {
    //特有方法: 讲课
    public void teaching() {
        System.out.println("讲师: " + name + " 正在讲解面向对象编程...");
    }
}
