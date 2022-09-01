package com.itheima.createobject;

public class Car {
    // 1.属性
    String name;

    double price;

    // 2.行为, 就是一个方法
    public void start() {
        System.out.println(name + "启动了");
    }

    public void run() {
        System.out.println("名字是：" + name + "，价格是：" + price + "的汽车跑得很快");
    }

}
