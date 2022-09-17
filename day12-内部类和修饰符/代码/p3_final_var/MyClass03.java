package com.itheima.p3_final_var;
/*
    成员变量: 看MyClass03 认为默认值无效,要么显式赋值,要么构造方法中赋值
        (1)定义未赋值:
            所有构造方法中,必须完成对final修饰的变量的赋值
            所有成员方法中,不能修改final修饰的变量的值

        (2)定义并赋值:
            所有构造方法/成员方法中,不能修改final修饰的变量的值
 */
public class MyClass03 {
    String name;
    final int num;//默认值无效,如果此处不给值,要求每个构造方法中都得给该变量赋值
    final int num2 = 20;//定义并赋值,其它所有构造方法和成员方法中都不能修改其值
    //空参构造
    public MyClass03() {
        num = 10;
        //num2 = 200;//错误
    }

    //有参构造
    public MyClass03(int num) {
        this.num = num;
        //num2 = 200;//错误
    }

    //满参构造
    public MyClass03(String name, int num) {
        this.name = name;
        this.num = num;
        //num2 = 200;//错误
    }

    //成员方法: 必须使用对象调用,对象都有了,构造方法早已经被调用了,num已经有值了
    public void method() {
        //num = 100;
        //num2 = 200;//错误
    }
}
