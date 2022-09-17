package com.itheima.p3_calendar;

/*
    猫都吃鱼,但是不同的品种的猫睡的方式不同,
    猫Cat09中没有覆盖重写睡的方法
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("🐱正在吃鱼...");
    }

    @Override
    public void sleep() {
        System.out.println("🐱正在睡觉...");
    }

    //特有方法
    public void catchMouse() {
        System.out.println("🐱正在抓老鼠...");
    }
}
