package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract void forEach(Consumer<T> con):
            按照方法参数con指定的规则对Stream流对象中的元素逐一处理
            参数:
                Consumer<T> con: 消费型接口,传递匿名内部类对象,lambda表达式
        java.util.function.Consumer<T>接口: 消费型接口 功能: 消费(处理)一个T类型的数据
        抽象方法:
            public abstract void accept(T t): 消费一个泛型指定类型的数据t
            accept单词: 接收的意思
            什么叫做消费呢?只要给accept方法添加方法体{},就叫做消费,不管{}中写的是什么
 */
public class Demo03ForEach {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");
        //1.匿名内部类的方式


        //2.使用lambda表达式的标准格式


        //2.使用lambda表达式的简化格式
    }
}