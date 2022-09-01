package com.itheima.p1_extends;
//定义子类班主任Manager类
public class Manager extends Employee {
    //特有方法: 管理班级
    public void managerClass() {
        System.out.println("班主任老师: " + name + " 正在和蔼可亲的管理班级...");
    }
}
