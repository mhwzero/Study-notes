package com.itheima.p5_duotai;
/*
    多态的好处和弊端
    不使用多态:
        好处: 可以调用子类的特有行为
        弊端: 扩展性极差
    使用多态:
        好处: 扩展性强
        弊端: 不可以调用子类的特有行为
*/
public class Demo06DuoTai {
    public static void main(String[] args) {
        //不使用多态:
        Dog dog = new Dog();
        //调用方法
        dog.eat();
        dog.sleep();
        //好处: 可以调用子类的特有行为
        dog.kanHome();

        //弊端: 扩展性极差
        //dog = new Cat();
        System.out.println("--------");

        //使用多态:
        Animal a = new Dog();

        //调用方法
        a.eat();
        a.sleep();

        //弊端: 不可以调用子类的特有行为
        //a.kanHome();

        a = new Cat();

        //好处: 扩展性强
        a.eat();
        a.sleep();
    }
}
