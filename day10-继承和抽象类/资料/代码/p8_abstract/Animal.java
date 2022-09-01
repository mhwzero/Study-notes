package com.itheima.p8_abstract;

//定义抽象父类动物Animal类
public abstract class Animal {
    //成员变量
    private String name;//名字
    private int weight;//重量

    //抽象方法: 吃
    public abstract void eat();

    //抽象方法: 睡
    public abstract void sleep();


    //展示信息
    public void show() {
        System.out.println("动物的名字: " + name + ", 重量: " + weight);
    }

    //注意: 父类构造不是让你直接创建父类对象的,因为父类是抽象的,不能直接new
    //是给子类用的,因为创建子类对象调用子类构造的时候,必须优先调用父类构造
    //空参构造方法
    public Animal() {
    }

    //满参构造方法
    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    //get/set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
