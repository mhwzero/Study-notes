package com.itheima.p3_baozhuang;
/*
    java.lang.Integer类对象的创建
    Integer 类在对象中包装了一个基本类型 int 的值。
    构造方法:
        public Integer(int value):
            把构造方法int参数value,转换成Integer对象

        public Integer(String value):
            把构造方法String参数value,转换成Integer对象
    思考:
        Integer类中有没有返回值是Integer类型的方法?

    静态方法:
        public static Integer valueOf(int i):
        	作用: 把方法参数int类型的i转换成Integer类型并返回

        public static Integer valueOf(String i):
        	作用: 把方法参数String类型的i转换成Integer类型并返回

    注意:
        1.构造方法/静态方法参数不可以超出int的范围
        2.构造方法/静态方法如果采用String的参数,参数中不可以包含非数字字符
*/
public class Demo04NewInteger {
    public static void main(String[] args) {
        //创建Integer类的对象: 构造方法传递int数据
        Integer i1 = new Integer(300);
        System.out.println("i1 = " + i1);

        //创建Integer类的对象: 构造方法传递String数据
        Integer i2 = new Integer("300");
        System.out.println("i2 = " + i2);

        //注意: 字符串不能包含非数字符合,也不能超过int的范围
        //Integer i3 = new Integer("300.0");
        //Integer i3 = new Integer("300a0");
        //Integer i3 = new Integer("300000000000000000000000000000000000000000000");

        //使用Integer类的静态方法valueOf创建对象
        Integer i4 = Integer.valueOf(300);
        System.out.println("i4 = " + i4);
        Integer i5 = Integer.valueOf("300");
        System.out.println("i5 = " + i5);
    }
}
