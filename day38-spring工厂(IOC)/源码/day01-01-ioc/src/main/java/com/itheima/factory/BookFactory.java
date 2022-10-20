package com.itheima.factory;

import com.itheima.domain.Book;

//静态工厂 : 直接调用工厂的静态方法获取对象
//实例化工厂: 先创建工厂实例,然后调用工厂实例的非静态方法
public class BookFactory {
    //创建书
    public static Book getBook1() {
        //封装对象创建过程99行代码
        return new Book();
    }

    public Book getBook2() {
        return new Book();
    }
}
