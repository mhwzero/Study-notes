package com.itheima.p2_interface;
//3.创建子类MyClass 继承 抽象父类AbstractClass 实现接口 MyInterA和MyInterB
public class MyClass extends AbstractClass implements MyInterA,MyInterB {
    //4.子类MyClass 覆盖重写抽象父类和接口中的所有的抽象方法
    @Override
    public void method() {
        System.out.println("MyClass...method...");
    }

    @Override
    public void show() {
        System.out.println("MyClass...show...");
    }

    @Override
    public void fun() {
        System.out.println("MyClass...fun...");
    }
}
