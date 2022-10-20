package com.itheima.te;

import com.itheima.domain.Book;
import com.itheima.factory.BookFactory;

public class App {
    public static void main(String[] args) {
        //1. 直接调用构造函数创建
        Book book = new Book();
        System.out.println(book);

        //2. 使用静态工厂创建
        Book book1 = BookFactory.getBook1();
        System.out.println(book1);

        //3. 使用实例化工厂创建
        BookFactory bookFactory = new BookFactory();
        Book book2 = bookFactory.getBook2();
        System.out.println(book2);
    }
}
