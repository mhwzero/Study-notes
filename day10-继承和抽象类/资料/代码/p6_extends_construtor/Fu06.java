package com.itheima.p6_extends_construtor;

public class Fu06 {
    int num;
    //父类的空参构造方法
    public Fu06() {
        System.out.println("父空参...");
    }

    //父类的满参构造方法
    public Fu06(int num) {
        this.num = num;
        System.out.println("父满参...");
    }

}
