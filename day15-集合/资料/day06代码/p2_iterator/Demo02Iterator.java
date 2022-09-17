package com.itheima.p2_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    迭代器遍历Collection集合
        1.创建Collection集合对象coll,存储数据类型String
        2.向Collection集合对象coll中添加多个数据
        3.使用Collection集合对象coll调用iterator方法,获取迭代器Iterator接口实现类对象it
        4..迭代器接口Iterator的实现类对象it调用hasNext方法,判断是否具有下一个元素
        5.如果有: 迭代器接口Iterator的实现类对象it调用next方法,获取下一个元素并输出

    注意:
        调用一次hasNext方法,只能对应的调用一次next方法
 */
public class Demo02Iterator {
    public static void main(String[] args) {
        //1.创建Collection集合对象coll,存储数据类型String
        Collection<String> coll = new ArrayList<>();
        //2.向Collection集合对象coll中添加多个数据
        coll.add("AAA");
        coll.add("DDD");
        coll.add("BBB");
        coll.add("CCC");
        //3.使用Collection集合对象coll调用iterator方法,获取迭代器Iterator接口实现类对象it
        Iterator<String> it = coll.iterator();
        //4..迭代器接口Iterator的实现类对象it调用hasNext方法,判断是否具有下一个元素
        while (it.hasNext()) {
            //5.如果有: 迭代器接口Iterator的实现类对象it调用next方法,获取下一个元素并输出
            System.out.println(it.next());
        }
    }
}
