package com.itheima.createobject;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：学会创建对象并使用
        // 1.先设计一个类

        // 2.创建类的对象
        Car car1 = new Car();
        System.out.println(car1);

        // 3.访问对象的属性
        car1.name = "宝马";
        System.out.println(car1.name);
        car1.price = 80.1;
        System.out.println(car1.price);

        // 4.访问对象的行为
        car1.start();
        car1.run();

        System.out.println("===============");
        Car car2 = new Car();
        // 3.访问对象的属性
        car2.name = "奔驰";
        System.out.println(car2.name);
        car2.price = 20.5;
        System.out.println(car2.price);

        // 4.访问对象的行为
        car2.start();
        car2.run();

    }
}
