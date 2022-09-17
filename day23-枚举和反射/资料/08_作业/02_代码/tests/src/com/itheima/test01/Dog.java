package com.itheima.test01;
//2、定义子类Dog，继承抽象父类Animal，重写抽象方法eat
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头....");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉....");
    }
}
