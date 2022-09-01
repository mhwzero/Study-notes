package com.itheima.p7_extends_test;

//定义子类讲师Teacher类
public class Teacher07 extends Employee07 {

    //根据父类生成空参/满参构造方法
    public Teacher07() {
    }

    public Teacher07(String name, int age, int salary) {
        super(name, age, salary);
    }

    //特有方法: 讲课
    public void teaching() {
        System.out.println("讲师: " + getName() + " 正在讲解面向对象编程...");
        //System.out.println("讲师: " + this.getName() + " 正在讲解面向对象编程...");
        //System.out.println("讲师: " + super.getName() + " 正在讲解面向对象编程...");
    }
}
