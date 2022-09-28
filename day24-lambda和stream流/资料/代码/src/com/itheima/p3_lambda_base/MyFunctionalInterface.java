package com.itheima.p3_lambda_base;
@FunctionalInterface
public interface MyFunctionalInterface {
    //抽象方法
    void method();
    //抽象方法: 不强制实现类必须覆盖重写的,因为Object类中有该方法的定义
    //相当于Object类帮助重写
    boolean equals(Object obj);

    //默认方法
    public default void show() {
        System.out.println("默认方法...show...");
    }

    //静态方法
    public static void fun() {
        System.out.println("静态方法...fun...");
    }
}
