package com.itheima.constructor;

public class Car {
    String name;
    double price;

    // 无参数构造器
    public Car() {
        System.out.println("无参数构造器被调用了");
    }

    // 有参数构造器
    public Car(String n, double p) {
        System.out.println("有参数构造器被调用了");
        name = n;
        price = p;
    }

}
