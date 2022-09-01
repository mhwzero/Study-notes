package com.itheima.p8_abstract;

//定义子类狗Dog 继承抽象父类动物Animal类
public class Dog extends Animal {
    //根据父类生成空参/满参构造方法
    public Dog() {
        super();
    }

    public Dog(String name, int weight) {
        super(name, weight);
    }

    //覆盖重写父类的抽象方法
    @Override
    public void eat() {
        System.out.println("🐕：名字： " + getName() + ", 重量: " + getWeight() + ", 正在吃骨头...");
    }

    @Override
    public void sleep() {
        System.out.println("🐕：名字： " + getName() + ", 重量: " + getWeight() + ", 正在睡觉...");
    }

    //特有方法: 看家
    public void kanHome() {
        System.out.println("🐕：名字： " + getName() + ", 重量: " + getWeight() + ", 正在看家...");
    }
}
