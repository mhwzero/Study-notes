package com.itheima.p7_extends_test;

//定义子类班主任Manager类
public class Manager07 extends Employee07 {
    //根据父类生成空参/满参构造方法
    public Manager07() {
    }

    public Manager07(String name, int age, int salary) {
        super(name, age, salary);
    }

    //特有方法: 管理班级
    public void managerClass() {
        System.out.println("班主任老师: " + getName() + " 正在和蔼可亲的管理班级...");
    }
}
