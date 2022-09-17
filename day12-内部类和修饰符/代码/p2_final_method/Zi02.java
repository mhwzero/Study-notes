package com.itheima.p2_final_method;

public class Zi02 extends Fu02 {
    @Override
    public void method() {
        System.out.println("Zi02...method...");
    }

    /*
    //错误: 父类show方法被final修饰,不能被重写
    @Override
    public void show() {
        System.out.println("Zi02...show...");
    }*/

    /*
        如果子类可以重写父类的方法,
        那么重写后可以添加final
     */
    @Override
    public final void fun() {
        System.out.println("Zi02...fun...");
    }
}
