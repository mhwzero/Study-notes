package com.itheima.test01;
//2、定义子类Cat，继承抽象父类Animal，重写抽象方法eat
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼....");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉");
    }

}
