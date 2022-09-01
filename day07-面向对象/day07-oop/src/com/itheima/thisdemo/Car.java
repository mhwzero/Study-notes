package com.itheima.thisdemo;

public class Car {
    String name;
    double price;

    public Car() {
        System.out.println("构造器中的this:" + this);
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void run() {
        System.out.println("run方法中的this:" + this);
//        this.goWith("保时捷");
        goWith("保时捷");
    }

    public void goWith(String name) {
        System.out.println(this.name + "正在和" + name + "比赛");
    }
}
