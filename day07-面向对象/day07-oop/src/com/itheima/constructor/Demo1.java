package com.itheima.constructor;

// constructor: 构造器
public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握构造器的使用
        Car c1 = new Car();
        System.out.println(c1.name);    // null
        System.out.println(c1.price);   // 0.0

        System.out.println("========");
        Car c2 = new Car("宝马", 50.1);
        System.out.println(c2.name);    // 宝马
        System.out.println(c2.price);   // 50.1

    }
}
