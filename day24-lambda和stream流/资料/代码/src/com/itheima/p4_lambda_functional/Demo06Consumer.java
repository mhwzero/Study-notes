package com.itheima.p4_lambda_functional;

import java.util.function.Consumer;

/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中
        java.util.function.Consumer<T>接口: 消费型接口 功能: 消费(处理)一个T类型的数据
        抽象方法:
            public abstract void accept(T t): 消费一个泛型指定类型的数据t
            accept单词: 接收的意思
            什么叫做消费呢?只要给accept方法添加方法体{},就叫做消费,不管{}中写的是什么
    练习:
        给你一个字符串,请按照大写的方式进行消费(输出处理)
 */
public class Demo06Consumer {
    public static void main(String[] args) {
        String s = "hello World";
        //1.调用方法传递匿名内部类对象
        fun(s, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });
        //2.调用方法传递lambda表达式标准格式
        fun(s, (String ss) -> {
                System.out.println(ss.toLowerCase());
            });
        //3.调用方法传递lambda表达式简化格式
        fun(s, ss -> System.out.println(ss.substring(6)));
    }

    /*
        定义方法,使用函数式接口Consumer作为参数
     */
    public static void fun(String str,Consumer<String> consumer) {
        //调用抽象方法accept,处理字符串ss
        //如何处理字符串ss,说不清
        consumer.accept(str);
    }
}
