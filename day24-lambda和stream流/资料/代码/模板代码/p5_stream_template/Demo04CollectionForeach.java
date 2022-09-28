package com.itheima.p5_stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

//Stream流遍历Collection集合
public class Demo04CollectionForeach {
    public static void main(String[] args) {
        //创建Collection集合
        Collection<String> coll = new ArrayList<>();
        //添加元素
        Collections.addAll(coll, "Hello", "Java", "C++", "Python");

        //单列和双列集合内部都有foreach方法,直接调用即可
        //单列集合调用forEach方法,传递匿名内部类对象

        System.out.println("----------");
        //单列集合调用forEach方法,传递lambda表达式标准格式
        System.out.println("----------");
        //单列集合调用forEach方法,传递lambda表达式标准格式
    }
}