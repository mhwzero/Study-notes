package com.itheima.p3_calendar;
//抽象方法
public abstract class Animal {
    //抽象方法
    public abstract void eat();
    public abstract void sleep();

    //静态方法,返回抽象类的子类对象
    public static Animal getInstance() {
        //必然一定需要返回Animal的子类对象/匿名内部类对象
        //return new Dog();
        return new Cat();
    }
}