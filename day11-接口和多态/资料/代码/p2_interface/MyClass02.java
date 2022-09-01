package com.itheima.p2_interface;
/*
    注意:
        子类必须重写父类和接口中的所有抽象方法,只要有一个抽象方法没有被重写,
        该子类必须定义为抽象类,看MyClass02类
 */
public abstract class MyClass02 extends AbstractClass implements MyInterA,MyInterB{
    @Override
    public void method() {

    }

    @Override
    public void show() {

    }
    /*
        抽象父类和接口中总共有3个抽象方法需要重写,
        但是子类只重写了2个,相当于子类内部有一个抽象方法,
        那么该子类必须定义为抽象类
     */
/*
    @Override
    public void fun() {

    }*/
}
