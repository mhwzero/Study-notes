package com.itheima.p4_lambda_functional;

import java.util.function.Supplier;

/*
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Supplier<T>接口: 供给型接口
        功能: 提供一个T类型的数据
        抽象方法:
            public abstract T get(): 获取一个泛型指定类型的数据
 */
public class Demo04Supplier {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        //1.调用方法传递匿名内部类对象
        fun(new Supplier<String>() {
            @Override
            public String get() {
                return s1 + s2;
            }
        });
        //2.调用方法传递lambda表达式标准格式
        fun(() -> {
            return s1.toUpperCase() + s2.toUpperCase();
        });
        //3.调用方法传递lambda表达式简化格式
        fun(() -> s1.toLowerCase() + s2.toLowerCase());

    }

    /*
        定义方法,使用函数式接口Supplier作为参数
     */
    public static void fun(Supplier<String> supplier) {
        //调用抽象方法get,获取字符串str
        //至于str的内容是什么以及如何获取,这里说不清楚
        String str = supplier.get();
        System.out.println(str);
    }
}
