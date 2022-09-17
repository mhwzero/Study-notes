package com.itheima.test05;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1、自定义注解@MyTest，保证自定义注解只能修饰方法，且在运行时可以获得。
@Target(ElementType.METHOD)//保证自定义注解只能修饰方法
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获得
public @interface MyTest {
}
