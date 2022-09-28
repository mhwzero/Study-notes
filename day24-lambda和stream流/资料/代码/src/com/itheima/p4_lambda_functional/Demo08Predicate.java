package com.itheima.p4_lambda_functional;

import java.util.function.Predicate;

/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Predicate<T>接口: 判断型接口 功能: 根据T类型的数据获取boolean类型的结果
        抽象方法:
            public abstract boolean test(T t): 根据方法参数T类型的数据t,返回一个boolean类型的结果

    练习:
        //1.练习:判断字符串长度是否大于5
        //2.练习:判断字符串是否包含"H"
 */
public class Demo08Predicate {
    public static void main(String[] args) {
        String ss = "itheima";
        //1.调用方法传递匿名内部类对象
        fun(ss, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;//判断字符串长度是否大于5
            }
        });
        //2.调用方法传递lambda表达式标准格式
        fun(ss, (String s) -> {
                return s.contains("H");//判断字符串是否包含"H"
            });
        //3.调用方法传递lambda表达式简化格式
        fun(ss, s -> s.contains("h"));//判断字符串是否包含"h"
    }

    /*
        定义方法,使用函数式接口Predicate作为参数
     */
    public static void fun(String str, Predicate<String> predicate) {
        //调用抽象方法test,根据字符串ss,获取boolean结果
        //至于根据字符串ss,如何获取boolean结果,说不清
        boolean result = predicate.test(str);
        System.out.println(result);
    }
}