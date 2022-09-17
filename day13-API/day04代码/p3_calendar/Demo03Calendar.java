package com.itheima.p3_calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
    java.util.Calendar类: 日历类,内部提供了大量的与日期时间相关的信息,想要什么就那什么,非常方便
    java.util.Calendar类是一个抽象类,不能直接创建对象
        不常用子类: java.util.GregorianCalendar类 用起来太麻烦


    解决方案:
        在java.util.Calendar类的内部提供静态方法获取其子类对象
            public static Calendar getInstance(): 获取抽象类Calendar类的子类对象
            返回值类型:
                java.util.Calendar类: 是抽象类,说明方法内部必然会返回该抽象类的子类对象
*/
public class Demo03Calendar {
    public static void main(String[] args) {
        //创建日历Calendar类的子类GregorianCalendar类的对象
        //1-12月: 内部对应的数字0-11
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2022, 8, 2);
        System.out.println(gregorianCalendar);

        //获取Animal的子类对象
        Animal a = Animal.getInstance();
        a.eat();
        a.sleep();

        //获取当前日期时间对应的Calendar对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
    }
}
