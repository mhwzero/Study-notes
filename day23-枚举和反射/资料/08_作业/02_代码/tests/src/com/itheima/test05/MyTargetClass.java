package com.itheima.test05;

//4、编写目标类MyTargetClass
//4.1、定义show方法,method方法，print方法，before方法，after方法
public class MyTargetClass {
    @MyTest
    public void print() {
        System.out.println("print...");
    }

    public void method() {
        System.out.println("method...");
    }

    @MyTest
    public void show() {
        System.out.println("show...");
    }

    @MyBefore
    public void before() {
        System.out.println("before....");
    }

    @MyAfter
    public void after() {
        System.out.println("after....");
    }    
}