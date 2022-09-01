package com.itheima.thisdemo;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握this关键字的作用和用法
        Car c1 = new Car();
        c1.run();
        System.out.println("当前对象的地址：" + c1);
//        c1.goWith("奔驰");

        System.out.println("=============");
        Car c2 = new Car("宝马", 50.1);
        System.out.println(c2.name);    //
        System.out.println(c2.price);   //

        c2.goWith("奔驰");

        System.out.println("=============");
        c2.run();
    }
}
