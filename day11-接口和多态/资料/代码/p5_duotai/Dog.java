package com.itheima.p5_duotai;

//定义子类狗Dog 继承抽象父类动物Animal类
public class Dog extends Animal {


    //覆盖重写父类的抽象方法
    @Override
    public void eat() {
        System.out.println("🐕正在吃骨头...");
    }

    @Override
    public void sleep() {
        System.out.println("🐕正在睡觉...");
    }

    //特有方法: 看家
    public void kanHome() {
        System.out.println("🐕正在看家...");
    }
}
