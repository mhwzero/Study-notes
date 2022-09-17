package com.itheima.p7_static_kuai;
/*
    静态代码块
        1.静态代码块格式:
            使用{}括起来的叫做代码块,加上static叫做静态代码
            static {...}

        2.特点:
            (1)假如只创建对象,静态代码块会优先于构造方法执行,唯一执行一次
            (2)静态代码块,随着类的加载而加载并唯一执行一次(因为: 类只会被加载一次)
            (3)完成静态成员变量的赋值
            (4)静态代码块,仍然属于静态内容,内部不能使用非静态
            (5)完成项目的初始化工作
 */
public class Demo07StaticKuai {
    public static void main(String[] args) {
        //创建Person类的对象
        //Person p = new Person();
        //Person p2 = new Person();

        //调用静态方法
        Person.showCountry();
    }
}
